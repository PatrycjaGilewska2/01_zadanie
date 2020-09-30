package com.capgemini.spring.zadanie.domain.exception;

public class IllegalBoardGameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalBoardGameException() {
	}

	public IllegalBoardGameException(String message) {
		super(message);
	}
}
