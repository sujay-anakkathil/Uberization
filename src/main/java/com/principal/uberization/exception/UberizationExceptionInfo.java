package com.principal.uberization.exception;

public enum UberizationExceptionInfo {
	
	UBERIZATION_BUSINESS_EXCEPTION(101,"Uberization business exception");
	private Integer errorCode;
	private String description;
	
	private UberizationExceptionInfo(Integer errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public String getDescription() {
		return description;
	}
	
}
