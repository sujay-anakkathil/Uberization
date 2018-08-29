package com.principal.uberization.exception;

public class ErrorMessage {

	private Integer errorCode;
	private String description;
	private String errorType;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public ErrorMessage(Integer errorCode, String description, String errorType) {
		this.errorCode = errorCode;
		this.description = description;
		this.errorType = errorType;
	}
	public ErrorMessage() {
	}
	
	
}
