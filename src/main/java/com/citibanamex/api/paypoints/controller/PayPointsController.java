package com.citibanamex.api.paypoints.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citibanamex.api.paypoints.model.EnablementRequest;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkageRequest;
import com.citibanamex.api.paypoints.model.RedemptionRequest;

@RestController
@RequestMapping("/v1")
public class PayPointsController {
	
	@RequestMapping(value="/rewards/{cloakedCreditCardNumber}/eligibility", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> checkRewards(
			@PathVariable("cloakedCreditCardNumber") String cloakedCard, 
			@RequestParam("rewardProgram") String rewardProgram,  
			@RequestParam("merchantCode") String merchantCode ,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value="businessCode",required=false) String businessCode ,
			@RequestHeader("Authorization") String Authorization ,
			@RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept,
			@RequestHeader("client_id") String client_id
			){
		IsEligible isEligible = new IsEligible();
		isEligible.setEligibilityIndicator("E");
		//String result = serviceimpl.checkRewardsEligibility(cloakedCard);
		return new ResponseEntity<>(isEligible,HttpStatus.OK);
//		return null;
		
	}
	
	@RequestMapping(value="/rewards/enablement", method=RequestMethod.PUT,produces = "application/json")
	public ResponseEntity<?> updatePayPoints(
			@RequestBody EnablementRequest enablementRequest, 
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value="businessCode",required=false) String businessCode ,
			@RequestHeader("Authorization") String Authorization ,
			@RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept,
			@RequestHeader("client_id") String client_id
			){
				return null;
		
	}
	
	@RequestMapping(value="/rewards/linkage", method=RequestMethod.POST,produces = "application/json")
	public ResponseEntity<?> createLinkCode(
			@RequestBody LinkageRequest linkageRequest,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value="businessCode",required=false) String businessCode ,
			@RequestHeader("Authorization") String Authorization ,
			@RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept,
			@RequestHeader("client_id") String client_id
			
			){
				return null;
		
	}
	
	@RequestMapping(value="/rewards/pointBalance", method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> retrieveRewards(
			@RequestParam("cloakedCreditCardNumber") String cloakedCreditCardNumber,
			@RequestHeader("countryCode") String countryCode,
			@RequestParam("rewardProgram") String rewardProgram,
			@RequestParam("rewardLinkCode") String rewardLinkCode,
			@RequestParam("merchantCode") String merchantCode,
			@RequestHeader(value="businessCode",required=false) String businessCode ,
			@RequestHeader("Authorization") String Authorization ,
			@RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept,
			@RequestHeader("client_id") String client_id
			){
				return null;
		
	}
	
	
	@RequestMapping(value="/rewards/redemption", method=RequestMethod.POST,produces = "application/json")
	public ResponseEntity<?> redeemReward(
			@RequestBody RedemptionRequest redemptionRequest,
			@RequestHeader("countryCode") String countryCode,
			@RequestHeader(value="businessCode",required=false) String businessCode ,
			@RequestHeader("Authorization") String Authorization ,
			@RequestHeader("uuid") String uuid,
			@RequestHeader("Accept") String Accept,
			@RequestHeader("client_id") String client_id
			){
				return null;
		
	}

}
