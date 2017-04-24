package com.citibanamex.api.pay.with.points.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"orderID","availablePointBalance"})
public class RedemptionOrderSummary {
	
	@JsonProperty("orderID")
	private String orderID;
	
	@JsonProperty("availablePointBalance")
	private Integer availablePointBalance;

	public RedemptionOrderSummary() {
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getAvailablePointBalance() {
		return availablePointBalance;
	}

	public void setAvailablePointBalance(Integer availablePointBalance) {
		this.availablePointBalance = availablePointBalance;
	}

}
