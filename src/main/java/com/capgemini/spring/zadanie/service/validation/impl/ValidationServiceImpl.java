package com.capgemini.spring.zadanie.service.validation.impl;

import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalBoardGameException;
import com.capgemini.spring.zadanie.domain.exception.IllegalPlayabilityException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.repository.BoardGameRepository;
import com.capgemini.spring.zadanie.repository.PlayabilityRepository;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;
import com.capgemini.spring.zadanie.service.validation.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

	@Autowired
	private BoardGameRepository boardGameService;

	@Autowired
	private UserInformationRepository userInformationService;

	@Autowired
	private PlayabilityRepository playabilityService;

	@Override
	public void validateUser(Long id) throws InvalidUserException {
		UserInformationDTO user = userInformationService.find(id);
		if (user == null) {
			throw new InvalidUserException("User is not in database");
		}
	}

	@Override
	public void validateGameInDatabase(Long id) throws IllegalBoardGameException {
		BoardGameDTO game = boardGameService.find(id);
		if (game == null) {
			throw new IllegalBoardGameException("Board does not exsist in database");
		}
	}

	@Override
	public void validateGameInUserCollection(UserInformationDTO user, BoardGameDTO game)
			throws IllegalBoardGameException {
		if (!user.getOwnedGames().contains(game)) {
			throw new IllegalBoardGameException("Board game is not in user collection");
		}
	}

	@Override
	public void validateName(String name) throws IllegalBoardGameException {
		if (name == null) {
			throw new IllegalBoardGameException("Name cannot be null");
		}
		if (name.trim().isEmpty()) {
			throw new IllegalBoardGameException("Name cannot be empty");
		}
		if (isGameNameExsisting(name)) {
			throw new IllegalBoardGameException("Name already in database");
		}

	}

	@Override
	public void validateDates(Date startDate, Date endDate) throws IllegalPlayabilityException {
		if (!startDate.before(endDate)) {
			throw new IllegalPlayabilityException("Start date cannot be after end date");
		}
	}

	@Override
	public void validatePlayability(Long id) throws IllegalPlayabilityException {
		if (playabilityService.find(id) == null) {
			throw new IllegalPlayabilityException("Playability not in database");
		}
	}

	@Override
	public void validateUserInformation(UserInformationDTO userInformation) throws InvalidUserException {
		if (userInformation.getFirstName().trim().isEmpty()) {
			throw new InvalidUserException("First name cannot be empty");
		}
		if (userInformation.getLastName().trim().isEmpty()) {
			throw new InvalidUserException("Last name cannot be empty");
		}
		if (userInformation.getPassword().trim().isEmpty()) {
			throw new InvalidUserException("Password cannot be empty");
		}
		if (!EmailValidator.getInstance().isValid(userInformation.getEmail())) {
			throw new InvalidUserException("Email is invalid");
		}
	}

	private boolean isGameNameExsisting(String name) {
		return boardGameService.find(name) != null;
	}

}
