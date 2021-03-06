package com.citibanamex.api.paypoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citibanamex.api.handler.exception.GlobalExceptionHandler;
import com.citibanamex.api.model.exception.CustomException;
import com.citibanamex.api.paypoints.model.EnablementRequest;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkStatus;
import com.citibanamex.api.paypoints.model.LinkageRequest;
import com.citibanamex.api.paypoints.model.PointBalance;
import com.citibanamex.api.paypoints.model.RedemptionOrderSummary;
import com.citibanamex.api.paypoints.model.RedemptionRequest;
import com.citibanamex.api.paypoints.service.PayPointService;

@RestController
@RequestMapping("/v1")
public class PayPointsController {

	private final String countryCodePattern = "([A-Z]){2}";
	private final String businessCodePattern = "\\w{3,}";
	
	@Autowired
	private PayPointService paypointservice;

	@RequestMapping(value = "/rewards/{cloakedCreditCardNumber}/eligibility", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> checkRewards(@PathVariable("cloakedCreditCardNumber") String cloakedCard,
			@RequestParam("rewardProgram") String rewardProgram, @RequestParam("merchantCode") String merchantCode,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value = "businessCode", required = false) String businessCode,
			@RequestHeader("Authorization") String Authorization, @RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept, @RequestHeader("client_id") String client_id) throws Exception {

		GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();
		
		if(countryCode == null || countryCode == ""){
			String message = "countryCodeBlank";
			CustomException customException = new CustomException(message); 
			return exceptionHandler.specialException(customException);
		}
		if(!countryCode.matches(countryCodePattern)){
			String message = "not a valid country code";
			CustomException customException = new CustomException(message); 
			return exceptionHandler.specialException(customException);
		}
		
		if(merchantCode == null || merchantCode == "" ){
			String message = "merchantCodeBlank";
			CustomException customException = new CustomException(message); 
			return exceptionHandler.specialException(customException);
		}
		
		if(merchantCode.length()>5){
			String message = "merchantCodeLengthExceeded";
			CustomException customException = new CustomException(message); 
			return exceptionHandler.specialException(customException);	
		}
		
		if(!businessCode.matches(businessCodePattern)){
			String message = "Not a valid business code";
			CustomException customException = new CustomException(message); 
			return exceptionHandler.specialException(customException);	
		} 
		
		IsEligible isEligible = paypointservice.checkRewards(cloakedCard);
		System.out.println("Elegibilidad: "+ isEligible.getEligibilityIndicator());

		// String result = serviceimpl.checkRewardsEligibility(cloakedCard);
		return new ResponseEntity<>(isEligible, HttpStatus.OK);
		// return null;

	}

	@RequestMapping(value = "/rewards/enablement", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updatePayPoints(@RequestBody EnablementRequest enablementRequest,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value = "businessCode", required = false) String businessCode,
			@RequestHeader("Authorization") String Authorization, @RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept, @RequestHeader("client_id") String client_id) {
		paypointservice.updatePayPoints(enablementRequest);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/rewards/linkage", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createLinkCode(@RequestBody LinkageRequest linkageRequest,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value = "businessCode", required = false) String businessCode,
			@RequestHeader("Authorization") String Authorization, @RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept, @RequestHeader("client_id") String client_id

	) {
		LinkStatus link = paypointservice.createLinkCode(linkageRequest);
		return new ResponseEntity<>(link, HttpStatus.OK);

	}

	@RequestMapping(value = "/rewards/pointBalance", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> retrieveRewards(@RequestParam("cloakedCreditCardNumber") String cloakedCreditCardNumber,
			@RequestHeader("countryCode") String countryCode, @RequestParam("rewardProgram") String rewardProgram,
			@RequestParam("rewardLinkCode") String rewardLinkCode, @RequestParam("merchantCode") String merchantCode,
			@RequestHeader(value = "businessCode", required = false) String businessCode,
			@RequestHeader("Authorization") String Authorization, @RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept, @RequestHeader("client_id") String client_id) {
		PointBalance point = paypointservice.retrieveRewards();

		return new ResponseEntity<>(point, HttpStatus.OK);

	}

	@RequestMapping(value = "/rewards/redemption", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> redeemReward(@RequestBody RedemptionRequest redemptionRequest,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value = "businessCode", required = false) String businessCode,
			@RequestHeader("Authorization") String Authorization, @RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept, @RequestHeader("client_id") String client_id) {
		
		RedemptionOrderSummary redemption=paypointservice.redeemReward();
		return new ResponseEntity<>(redemption, HttpStatus.OK);

	}

	
}
