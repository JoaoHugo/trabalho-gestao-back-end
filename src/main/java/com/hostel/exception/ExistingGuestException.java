package com.hostel.exception;

public class ExistingGuestException extends RuntimeException{

	private static final long serialVersionUID = 1244333128873033535L;

	public ExistingGuestException(String message) {
		super(message);
	}
}
