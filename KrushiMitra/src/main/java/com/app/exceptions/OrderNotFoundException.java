package com.app.exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException extends Exception {

	public OrderNotFoundException(String message) {
		super(message);
	}

}
