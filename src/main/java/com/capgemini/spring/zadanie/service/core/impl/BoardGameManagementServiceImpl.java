package com.capgemini.spring.zadanie.service.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalBoardGameException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.repository.BoardGameRepository;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;
import com.capgemini.spring.zadanie.service.core.BoardGameManagementService;
import com.capgemini.spring.zadanie.service.validation.ValidationService;

@Service
public class BoardGameManagementServiceImpl implements BoardGameManagementService {

	@Autowired
	private ValidationService validationService;

	@Autowired
	private BoardGameRepository boardGameService;

	@Autowired
	private UserInformationRepository userInformationService;

	@Override
	public List<BoardGameDTO> findAll() {
		return boardGameService.findAll();
	}

	@Override
	public void addGame(String name) throws IllegalBoardGameException {
		validationService.validateName(name);
		BoardGameDTO gameToSave = new BoardGameDTO(null, name);
		boardGameService.save(gameToSave);
	}

	@Override
	public void addGameToUserCollection(Long userId, Long gameId)
			throws InvalidUserException, IllegalBoardGameException {
		validationService.validateUser(userId);
		UserInformationDTO user = userInformationService.find(userId);
		validationService.validateGameInDatabase(gameId);
		BoardGameDTO game = boardGameService.find(gameId);
		user.addGame(game);
		userInformationService.update(user);
	}

	@Override
	public void removeGameFromUserCollection(Long userId, Long gameId)
			throws InvalidUserException, IllegalBoardGameException {
		validationService.validateUser(userId);
		UserInformationDTO user = userInformationService.find(userId);
		validationService.validateGameInDatabase(gameId);
		BoardGameDTO game = boardGameService.find(gameId);
		validationService.validateGameInUserCollection(user, game);
		user.removeGame(game);
		userInformationService.update(user);
	}

	@Override
	public List<BoardGameDTO> showUserGames(Long userId) throws InvalidUserException {
		validationService.validateUser(userId);
		UserInformationDTO user = userInformationService.find(userId);
		return user.getOwnedGames();
	}
}
