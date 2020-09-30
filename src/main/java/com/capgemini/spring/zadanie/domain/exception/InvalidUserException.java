package com.capgemini.spring.zadanie.domain.exception;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserException() {
	}

	public InvalidUserException(String message) {
		super(message);
	}
}
