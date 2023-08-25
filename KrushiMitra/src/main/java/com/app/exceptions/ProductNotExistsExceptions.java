package com.app.exceptions;

@SuppressWarnings("serial")
public class ProductNotExistsExceptions extends RuntimeException {
	public ProductNotExistsExceptions(String message) {
		super(message);
	}
}
