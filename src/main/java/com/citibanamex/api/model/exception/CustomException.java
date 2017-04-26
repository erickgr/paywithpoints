package com.citibanamex.api.model.exception;

public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
	public CustomException(String message) {
	super();
	this.message = message;
	}
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
	* @return the message
	*/
	public String getMessage() {
	return message;
	}
	/**
	* @param message the message to set
	*/
	public void setMessage(String message) {
	this.message = message;
	}

}
