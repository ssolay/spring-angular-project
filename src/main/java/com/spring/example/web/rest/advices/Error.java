package com.spring.example.web.rest.advices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Error {

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
	private int code;
    private String message;
    
    public Error(int code, String message)
    {
    	this.code = code;
    	this.message = message;
    }
}
