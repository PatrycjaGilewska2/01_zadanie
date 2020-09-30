package com.capgemini.spring.zadanie.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.repository.BoardGameRepository;

public class BoardGameRepositoryImplTest {

	private final int INIT_BOARDGAME_SIZE = 5;
	private final BoardGameDTO BOARDGAME_ON_INDEX_3 = new BoardGameDTO(4l, "Yenga");
	private final Long LAST_USED_ID = 5L;

	private BoardGameRepository boardGameRepository;

	@Before 
	public void init() {
		boardGameRepository = new BoardGameRepositoryImpl();
	}

	@Test
	public void shouldReturnAllElements() {
		// when
		List<BoardGameDTO> allElements = boardGameRepository.findAll();
		// then
		assertEquals(INIT_BOARDGAME_SIZE, allElements.size());
		assertEquals(BOARDGAME_ON_INDEX_3, allElements.get(3));
	}

	@Test
	public void shouldFindCorrecElementById() {
		// when
		BoardGameDTO actualElements = boardGameRepository.find(4L);
		// then
		assertEquals(BOARDGAME_ON_INDEX_3, actualElements);
	}

	@Test
	public void shouldFindCorrecElementByName() {
		// when
		BoardGameDTO actualElements = boardGameRepository.find("Yenga");
		// then
		assertEquals(BOARDGAME_ON_INDEX_3, actualElements);
	}

	@Test
	public void shouldReturnNullWhenIdNotInRepository() {
		// when
		BoardGameDTO actualElements = boardGameRepository.find(78L);
		// then
		assertNull(actualElements);
	}

	@Test
	public void shouldReturnNullWhenNameNotInRepository() {
		// when
		BoardGameDTO actualElements = boardGameRepository.find("Yengadsa");
		// then
		assertNull(actualElements);
	}

	@Test
	public void shouldSaveNewElementWithNextFreeId() {
		// given
		BoardGameDTO expectedSavedDTO = new BoardGameDTO(LAST_USED_ID + 1, "Szachy");
		// when
		boardGameRepository.save(new BoardGameDTO(null, "Szachy"));
		// then
		List<BoardGameDTO> allElements = boardGameRepository.findAll();
		assertEquals(INIT_BOARDGAME_SIZE + 1, allElements.size());
		assertEquals(expectedSavedDTO, allElements.get(allElements.size() - 1));
	}

	@Test
	public void shouldUpdateElement() {
		// given
		BoardGameDTO expectedUpdatedDTO = new BoardGameDTO(LAST_USED_ID, "Szachy");
		// when
		boardGameRepository.update(new BoardGameDTO(LAST_USED_ID, "Szachy"));
		// then
		List<BoardGameDTO> allElements = boardGameRepository.findAll();
		BoardGameDTO actualElement = boardGameRepository.find(LAST_USED_ID);
		assertEquals(INIT_BOARDGAME_SIZE, allElements.size());
		assertEquals(expectedUpdatedDTO, actualElement);
	}

	@Test
	public void shouldDeleteProvidedElement() {
		// when
		boardGameRepository.delete(BOARDGAME_ON_INDEX_3);
		// then
		List<BoardGameDTO> allElements = boardGameRepository.findAll();
		BoardGameDTO deletedElement = boardGameRepository.find(BOARDGAME_ON_INDEX_3.getId());
		assertEquals(INIT_BOARDGAME_SIZE - 1, allElements.size());
		assertNull(deletedElement);
	}

	@Test
	public void shouldDeleteElementById() {
		// when
		boardGameRepository.delete(BOARDGAME_ON_INDEX_3);
		// then
		List<BoardGameDTO> allElements = boardGameRepository.findAll();
		BoardGameDTO deletedElement = boardGameRepository.find(BOARDGAME_ON_INDEX_3.getId());
		assertEquals(INIT_BOARDGAME_SIZE - 1, allElements.size());
		assertNull(deletedElement);
	}
}
