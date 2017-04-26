package com.citibanamex.api.paypoints.serviceImpl;

import org.springframework.stereotype.Service;

import com.citibanamex.api.paypoints.model.EnablementRequest;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkStatus;
import com.citibanamex.api.paypoints.model.LinkageRequest;
import com.citibanamex.api.paypoints.model.PointBalance;
import com.citibanamex.api.paypoints.model.RedemptionOrderSummary;
import com.citibanamex.api.paypoints.service.PayPointService;

@Service
public class PayPointServiceImpl implements PayPointService {

	@Override
	public IsEligible checkRewards(String cloakedCard) {
		IsEligible ok= new IsEligible();
		
		if(cloakedCard.equals("sha-11")){
			ok.setEligibilityIndicator("E");
			return ok;
		}
		
		if(cloakedCard.equals("sha-12")){
			ok.setEligibilityIndicator("Y");
			return ok;
		}
		
		if(cloakedCard.equals("sha-13")){
			ok.setEligibilityIndicator("N");
			return ok;
		}
		
		return ok;
	}
/*
 * There is no back end an we mock the process here.
 * 
 */
	@Override
	public void updatePayPoints(EnablementRequest enablementRequest) {
		System.out.println("1.-"+enablementRequest.getCloakedCreditCardNumber());
		System.out.println("1.-"+enablementRequest.getMerchantCode());
		System.out.println("1.-"+enablementRequest.getRewardLinkCode());
		System.out.println("1.-"+enablementRequest.getRewardProgram());
		enablementRequest.setEnableProgramIndicator(false);
		
	}
	@Override
	public LinkStatus createLinkCode(LinkageRequest linkageRequest) {
		LinkStatus obj = new LinkStatus();
		obj.setRewardLinkCode(":D");
		return obj;
	}

	@Override
	public PointBalance retrieveRewards() {
		// TODO Auto-generated method stub
		PointBalance balance = new  PointBalance();
		balance.setAvailablePointBalance(100);
		balance.setLocalCurrencyCode("MXN");
		balance.setMaximumPointsToRedeem(20);
		balance.setMinimumPointsToRedeem(30);
		balance.setProgramConversionRate(23);
		balance.setRedemptionEligible(true);
		balance.setRedemptionPointIncrement(15);
		return balance;
	}

	@Override
	public RedemptionOrderSummary redeemReward() {
		// TODO Auto-generated method stub
		RedemptionOrderSummary orderSummary = new RedemptionOrderSummary();
		orderSummary.setAvailablePointBalance(100);
		orderSummary.setOrderID("ABI1");
		return orderSummary;
	}

}
