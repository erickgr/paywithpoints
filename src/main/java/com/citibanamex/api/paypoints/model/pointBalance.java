package com.citibanamex.api.paypoints.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"isRedemptionEligible","availablePointBalance","programConversionRate","localCurrencyCode","redemptionPointIncrement","maximumPointsToRedeem","minimumPointsToRedeem"})
public class pointBalance {
	
	@JsonProperty("isRedemptionEligible")
	private boolean isRedemptionEligible;
	
	@JsonProperty("availablePointBalance")
	private Integer availablePointBalance;
	
	@JsonProperty("programConversionRate")
	private Number programConversionRate;
	
	@JsonProperty("localCurrencyCode")
	private String localCurrencyCode;
	
	@JsonProperty("redemptionPointIncrement")
	private Integer redemptionPointIncrement;
	
	@JsonProperty("maximumPointsToRedeem")
	private Integer maximumPointsToRedeem;
	
	@JsonProperty("minimumPointsToRedeem")
	private Integer minimumPointsToRedeem;
	
	
	public pointBalance(){}


	public boolean isRedemptionEligible() {
		return isRedemptionEligible;
	}


	public void setRedemptionEligible(boolean isRedemptionEligible) {
		this.isRedemptionEligible = isRedemptionEligible;
	}


	public Integer getAvailablePointBalance() {
		return availablePointBalance;
	}


	public void setAvailablePointBalance(Integer availablePointBalance) {
		this.availablePointBalance = availablePointBalance;
	}


	public Number getProgramConversionRate() {
		return programConversionRate;
	}


	public void setProgramConversionRate(Number programConversionRate) {
		this.programConversionRate = programConversionRate;
	}


	public String getLocalCurrencyCode() {
		return localCurrencyCode;
	}


	public void setLocalCurrencyCode(String localCurrencyCode) {
		this.localCurrencyCode = localCurrencyCode;
	}


	public Integer getRedemptionPointIncrement() {
		return redemptionPointIncrement;
	}


	public void setRedemptionPointIncrement(Integer redemptionPointIncrement) {
		this.redemptionPointIncrement = redemptionPointIncrement;
	}


	public Integer getMaximumPointsToRedeem() {
		return maximumPointsToRedeem;
	}


	public void setMaximumPointsToRedeem(Integer maximumPointsToRedeem) {
		this.maximumPointsToRedeem = maximumPointsToRedeem;
	}


	public Integer getMinimumPointsToRedeem() {
		return minimumPointsToRedeem;
	}


	public void setMinimumPointsToRedeem(Integer minimumPointsToRedeem) {
		this.minimumPointsToRedeem = minimumPointsToRedeem;
	}
	
	
}
