package com.ssm.exception;

@SuppressWarnings("serial")
public class MenuException extends RuntimeException {

	public MenuException(String message) {
        super(message);
    }

    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
