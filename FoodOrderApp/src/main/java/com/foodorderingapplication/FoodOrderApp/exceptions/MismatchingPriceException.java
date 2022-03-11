package com.foodorderingapplication.FoodOrderApp.exceptions;

public class MismatchingPriceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MismatchingPriceException(String message) {
		super(message);
	}

}
