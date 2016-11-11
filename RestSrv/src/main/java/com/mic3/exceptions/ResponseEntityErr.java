package com.mic3.exceptions;

public class ResponseEntityErr {
	
	int code;
	String message;
	
	public ResponseEntityErr(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
