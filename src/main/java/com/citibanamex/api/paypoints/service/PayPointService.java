package com.citibanamex.api.paypoints.service;


import com.citibanamex.api.paypoints.model.EnablementRequest;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkStatus;
import com.citibanamex.api.paypoints.model.LinkageRequest;
import com.citibanamex.api.paypoints.model.PointBalance;
import com.citibanamex.api.paypoints.model.RedemptionOrderSummary;


public interface PayPointService {
	
	IsEligible checkRewards(String cloakedCard);
	
	void  updatePayPoints(EnablementRequest enablementRequest);
	
	LinkStatus createLinkCode(LinkageRequest linkageRequest);
	
	PointBalance retrieveRewards();
	
	RedemptionOrderSummary redeemReward();
	
}
