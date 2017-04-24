package com.citibanamex.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"rewardProgram","merchantCode","cloakedCreditCardNumber","billingZipCode"})
public class LinkageRequest {
	@JsonProperty("rewardProgram")
	private String rewardProgram;
	@JsonProperty("merchantCode")
	private String merchantCode;
	@JsonProperty("cloakedCreditCardNumber")
	private String cloakedCreditCardNumber;
	@JsonProperty("billingZipCode")
	private String billingZipCode;
	
	public LinkageRequest(){}

	public String getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(String rewardProgram) {
		this.rewardProgram = rewardProgram;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getCloakedCreditCardNumber() {
		return cloakedCreditCardNumber;
	}

	public void setCloakedCreditCardNumber(String cloakedCreditCardNumber) {
		this.cloakedCreditCardNumber = cloakedCreditCardNumber;
	}

	public String getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}
	
	
}
