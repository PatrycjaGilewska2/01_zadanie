package com.capgemini.spring.zadanie.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalBoardGameException;
import com.capgemini.spring.zadanie.service.core.BoardGameManagementService;

@RestController
public class GameController {

	@Autowired
	private BoardGameManagementService boardGameManagementService;

	@GetMapping(value = "/games")
	private List<BoardGameDTO> findAllGames() {
		List<BoardGameDTO> findAll = boardGameManagementService.findAll();
		return findAll;
	}

	@PostMapping(value = "/games/add/{name}")
	private void addGame(@PathVariable("name") String name) throws IllegalBoardGameException {
		boardGameManagementService.addGame(name);
	}
	
	@PostMapping(value = "/games/add")
	private void addBoardGame(@RequestBody BoardGameDTO boardGame) throws IllegalBoardGameException {
		boardGameManagementService.addGame(boardGame.getGameName());
	}
}
