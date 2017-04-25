package com.citibanamex.api.paypoints.serviceImpl;

import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkStatus;
import com.citibanamex.api.paypoints.model.PointBalance;
import com.citibanamex.api.paypoints.model.RedemptionOrderSummary;

public class PayPointServiceImpl {

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

	public void updatePayPoints() {

	}

	public LinkStatus createLinkCode() {
		return null;
	}

	public PointBalance retrieveRewards() {
		return null;
	}

	public RedemptionOrderSummary redeemReward() {
		return null;
	}
}
