package com.in28minutes.junit.business.exception;

public class DifferentCurrenciesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public DifferentCurrenciesException() {
		this.message = "Different Currencies are not allowed";
	}
	
	public DifferentCurrenciesException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
