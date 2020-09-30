package com.capgemini.spring.zadanie.service.validation;

import java.util.Date;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalBoardGameException;
import com.capgemini.spring.zadanie.domain.exception.IllegalPlayabilityException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;

public interface ValidationService {

	public void validateUser(Long id) throws InvalidUserException;

	public void validateGameInDatabase(Long id) throws IllegalBoardGameException;

	public void validateName(String name) throws IllegalBoardGameException;

	public void validateGameInUserCollection(UserInformationDTO user, BoardGameDTO game)
			throws IllegalBoardGameException;

	public void validateDates(Date startDate, Date endDate) throws IllegalPlayabilityException;

	public void validatePlayability(Long id) throws IllegalPlayabilityException;

	public void validateUserInformation(UserInformationDTO userInformation) throws InvalidUserException;
}
