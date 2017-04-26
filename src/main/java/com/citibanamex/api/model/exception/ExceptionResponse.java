package com.citibanamex.api.model.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

	private int code;
	private String description;
	private String errorMessage;
	private String Status;
	/**
	* @return the code
	*/
	public int getCode() {
	return code;
	}
	/**
	* @param code the code to set
	*/
	public void setCode(int code) {
	this.code = code;
	}
	/**
	* @return the description
	*/
	public String getDescription() {
	return description;
	}
	/**
	* @param description the description to set
	*/
	public void setDescription(String description) {
	this.description = description;
	}
	/**
	* @return the errorMessage
	*/
	public String getErrorMessage() {
	return errorMessage;
	}
	/**
	* @param errorMessage the errorMessage to set
	*/
	public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
	}
	/**
	* @return the status
	*/
	public String getStatus() {
	return Status;
	}
	/**
	* @param status the status to set
	*/
	public void setStatus(String status) {
	Status = status;
	}
}
