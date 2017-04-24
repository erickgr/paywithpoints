package com.citibanamex.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"transactionAmount","pointsToRedeem","transactionDescription"})
public class RedemptionOrder {
	
	@JsonProperty("transactionAmount")
	private Number transactionAmount;
	
	@JsonProperty("pointsToRedeem")
	private Integer pointsToRedeem;
	
	@JsonProperty("transactionDescription")
	private String transactionDescription;

	public RedemptionOrder() {
	}

	public Number getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Number transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Integer getPointsToRedeem() {
		return pointsToRedeem;
	}

	public void setPointsToRedeem(Integer pointsToRedeem) {
		this.pointsToRedeem = pointsToRedeem;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

}
