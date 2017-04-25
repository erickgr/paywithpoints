package com.citibanamex.api.paypoints.service;

import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkStatus;
import com.citibanamex.api.paypoints.model.PointBalance;

public interface PayPointService {
	
	public IsEligible checkRewards(String cloakedCard);
	
	public void  updatePayPoints();
	
	public LinkStatus createLinkCode();
	
	public PointBalance retrieveRewards();
	
	public void redeemReward();
	
}
