package com.capgemini.spring.zadanie.domain.exception;

public class IllegalPlayabilityException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalPlayabilityException() {
	}

	public IllegalPlayabilityException(String message) {
		super(message);
	}
}
