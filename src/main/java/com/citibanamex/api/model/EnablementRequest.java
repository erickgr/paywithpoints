package com.citibanamex.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"rewardProgram","merchantCode","enableProgramIndicator","cloakedCreditCardNumber","rewardLinkCode"})
public class EnablementRequest {
	
	@JsonProperty("rewardProgram")
	private String rewardProgram;
	
	@JsonProperty("merchantCode")
	private String merchantCode;
	
	@JsonProperty("enableProgramIndicator")
	private boolean enableProgramIndicator;
	
	@JsonProperty("cloakedCreditCardNumber")
	private String cloakedCreditCardNumber;
	
	@JsonProperty("rewardLinkCode")
	private String rewardLinkCode;

	public EnablementRequest() {
	}

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

	public boolean isEnableProgramIndicator() {
		return enableProgramIndicator;
	}

	public void setEnableProgramIndicator(boolean enableProgramIndicator) {
		this.enableProgramIndicator = enableProgramIndicator;
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

}
