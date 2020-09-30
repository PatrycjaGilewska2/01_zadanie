package com.capgemini.spring.zadanie.service.core;

import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalBoardGameException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;

public interface BoardGameManagementService {
	
	public List<BoardGameDTO> findAll();

	public void addGame(String name) throws IllegalBoardGameException;

	public void addGameToUserCollection(Long userId, Long gameId) throws InvalidUserException, IllegalBoardGameException;

	public void removeGameFromUserCollection(Long userId, Long gameId) throws InvalidUserException, IllegalBoardGameException;

	public List<BoardGameDTO> showUserGames(Long userId) throws InvalidUserException;
}
