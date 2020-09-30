package com.capgemini.spring.zadanie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.entity.BoardGameEntity;
import com.capgemini.spring.zadanie.domain.mapper.BoardGameMapper;
import com.capgemini.spring.zadanie.repository.BoardGameRepository;
import com.capgemini.spring.zadanie.repository.DataUtil;

@Repository
public class BoardGameRepositoryImpl implements BoardGameRepository {

	private List<BoardGameEntity> boardGames = new ArrayList<>();

	public BoardGameRepositoryImpl() {
		boardGames.add(DataUtil.game1);
		boardGames.add(DataUtil.game2);
		boardGames.add(DataUtil.game3);
		boardGames.add(DataUtil.game4);
		boardGames.add(DataUtil.game5);
	}

	@Override
	public List<BoardGameDTO> findAll() {
		return BoardGameMapper.mapToDTOs(boardGames);
	}

	@Override
	public BoardGameDTO find(Long id) {
		for (BoardGameEntity boardGameEntity : boardGames) {
			if (boardGameEntity.getId() == id) {
				return BoardGameMapper.map(boardGameEntity);
			}
		}
		return null;
	}

	@Override
	public BoardGameDTO find(String gameName) {
		for (BoardGameEntity boardGameEntity : boardGames) {
			if (boardGameEntity.getGameName().equals(gameName)) {
				return BoardGameMapper.map(boardGameEntity);
			}
		}
		return null;
	}

	@Override
	public void save(BoardGameDTO boardGameToSave) {
		BoardGameEntity boardGame = BoardGameMapper.map(boardGameToSave);
		boardGame.setId(getNextId());
		boardGames.add(boardGame);
	}

	@Override
	public void update(BoardGameDTO boardGameToUpdate) {
		BoardGameEntity boardGame = BoardGameMapper.map(boardGameToUpdate);
		int index = boardGames.indexOf(BoardGameMapper.map(find(boardGame.getId())));
		boardGames.set(index, boardGame);
	}

	@Override
	public void delete(BoardGameDTO boardGameToDelete) {
		BoardGameEntity boardGame = BoardGameMapper.map(boardGameToDelete);
		boardGames.remove(boardGame);
	}

	private long getNextId() {
		long maxId = Long.MIN_VALUE;
		for (BoardGameEntity boardGameEntity : boardGames) {
			if (boardGameEntity.getId() > maxId) {
				maxId = boardGameEntity.getId();
			}
		}
		return ++maxId;
	}
}
