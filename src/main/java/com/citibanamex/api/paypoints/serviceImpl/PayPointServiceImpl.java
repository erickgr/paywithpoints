package com.citibanamex.api.paypoints.serviceImpl;

import org.springframework.stereotype.Service;

import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkStatus;
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

	@Override
	public void updatePayPoints() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkStatus createLinkCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PointBalance retrieveRewards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RedemptionOrderSummary redeemReward() {
		// TODO Auto-generated method stub
		return null;
	}

}
