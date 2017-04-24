package com.citibanamex.api.paypoints.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"orderID","availablePointBalance"})
public class RedemptionRequest {
	
	@JsonProperty("rewardProgram")
	private String rewardProgram;
	
	@JsonProperty("cloakedCreditCardNumber")
	private String cloakedCreditCardNumber;
	
	@JsonProperty("rewardLinkCode")
	private String rewardLinkCode;
	
	@JsonProperty("merchantCode")
	private String merchantCode;
	
	@JsonProperty("transactionReferenceNumber")
	private String transactionReferenceNumber;
	
	@JsonProperty("redemptionOrder")
	private RedemptionOrder redemptionOrder;
	
	public RedemptionRequest(){}

	public String getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
	}

	public String getCloakedCreditCardNumber() {
		return cloakedCreditCardNumber;
	}

	public void setCloakedCreditCardNumber(String cloakedCreditCardNumber) {
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
	}

	public String getRewardLinkCode() {
		return rewardLinkCode;
	}

	public void setRewardLinkCode(String rewardLinkCode) {
		this.rewardLinkCode = rewardLinkCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}

	public void setTransactionReferenceNumber(String transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}

	public RedemptionOrder getRedemptionOrder() {
		return redemptionOrder;
	}

	public void setRedemptionOrder(RedemptionOrder redemptionOrder) {
		this.redemptionOrder = redemptionOrder;
	}
	
	
}
