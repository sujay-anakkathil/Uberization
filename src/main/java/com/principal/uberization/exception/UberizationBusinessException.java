package com.principal.uberization.exception;

import java.util.ArrayList;
import java.util.List;

public class UberizationBusinessException extends Exception{
	private static final long serialVersionUID = 1L;
	private List<ErrorMessage> messageList = new ArrayList<>();
	
	public List<ErrorMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<ErrorMessage> messageList) {
		this.messageList = messageList;
	}

	public UberizationBusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UberizationBusinessException() {
	}
}
