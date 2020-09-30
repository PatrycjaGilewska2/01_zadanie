package com.capgemini.spring.zadanie.domain.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.entity.BoardGameEntity;

public class BoardGameMapperTest {

	@Test
	public void shouldReturnCorrectEntity() {
		//given
		BoardGameEntity expectedEntity = new BoardGameEntity(1l, "Taboo");
		BoardGameDTO dto = new BoardGameDTO(1l, "Taboo");
		//when
		BoardGameEntity actual = BoardGameMapper.map(dto);
		//then
		assertEquals(expectedEntity, actual);
	}

	@Test
	public void shouldReturnCorrectDTO() {
		//given
		BoardGameEntity entity = new BoardGameEntity(1l, "Taboo");
		BoardGameDTO expectedDTO = new BoardGameDTO(1l, "Taboo");
		//when
		BoardGameDTO actual = BoardGameMapper.map(entity);
		//then
		assertEquals(expectedDTO, actual);
	}
}
