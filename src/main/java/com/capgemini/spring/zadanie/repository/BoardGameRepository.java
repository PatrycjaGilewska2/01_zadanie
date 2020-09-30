package com.capgemini.spring.zadanie.repository;

import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;

public interface BoardGameRepository {

	public List<BoardGameDTO> findAll();

	public BoardGameDTO find(Long id);

	public BoardGameDTO find(String gameName);

	public void save(BoardGameDTO boardGameToSave);

	public void update(BoardGameDTO boardGameToUpdate);

	public void delete(BoardGameDTO boardGameToDelete);
}
