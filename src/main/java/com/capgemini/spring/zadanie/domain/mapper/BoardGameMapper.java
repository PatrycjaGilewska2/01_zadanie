package com.capgemini.spring.zadanie.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.entity.BoardGameEntity;

public class BoardGameMapper {

	public static BoardGameDTO map(BoardGameEntity boardGameEntity) {
		if (boardGameEntity == null) {
			return null;
		}

		BoardGameDTO boardGameDTO = new BoardGameDTO();
		boardGameDTO.setId(boardGameEntity.getId());
		boardGameDTO.setGameName(boardGameEntity.getGameName());
		return boardGameDTO;
	}

	public static BoardGameEntity map(BoardGameDTO boardGameDTO) {
		if (boardGameDTO == null) {
			return null;
		}

		BoardGameEntity boardGameEntity = new BoardGameEntity();
		boardGameEntity.setId(boardGameDTO.getId());
		boardGameEntity.setGameName(boardGameDTO.getGameName());

		return boardGameEntity;
	}

	public static List<BoardGameEntity> mapToEntities(List<BoardGameDTO> boardGameDTOs) {

		List<BoardGameEntity> boardGameEntities = new ArrayList<>();

		for (BoardGameDTO boardGameDTO : boardGameDTOs) {
			boardGameEntities.add(map(boardGameDTO));
		}

		return boardGameEntities;
	}

	public static List<BoardGameDTO> mapToDTOs(List<BoardGameEntity> boardGameEntities) {

		List<BoardGameDTO> boardGameDTOs = new ArrayList<>();

		for (BoardGameEntity boardGameEntity : boardGameEntities) {
			boardGameDTOs.add(map(boardGameEntity));
		}

		return boardGameDTOs;
	}

}