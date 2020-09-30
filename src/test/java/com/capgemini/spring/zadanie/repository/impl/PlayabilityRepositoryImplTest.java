package com.capgemini.spring.zadanie.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.mapper.PlayabilityMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.PlayabilityRepository;

public class PlayabilityRepositoryImplTest {

	private final UserInformationDTO userInfo4 = DataUtil.userInfo4;

	private final int INIT_BOARDGAME_SIZE = 5;

	private final PlayabilityDTO BOARDGAME_ON_INDEX_3 = PlayabilityMapper.map(DataUtil.playability4);
	private final PlayabilityDTO BOARDGAME_ON_INDEX_0 = PlayabilityMapper.map(DataUtil.playability1);
	private final PlayabilityDTO BOARDGAME_ON_INDEX_4 = PlayabilityMapper.map(DataUtil.playability5);

	private final Long LAST_USED_ID = 3l;

	private PlayabilityRepository playabilityRepository;

	@Before
	public void init() {
		playabilityRepository = new PlayabilityRepositoryImpl();
	}

	@Test
	public void shouldReturnAllElements() {
		// when
		List<PlayabilityDTO> allElements = playabilityRepository.findAll();
		// then
		assertEquals(INIT_BOARDGAME_SIZE, allElements.size());
	}

	@Test
	public void shouldFindCorrecElementById() {
		// when
		PlayabilityDTO actualElements1 = playabilityRepository.find(4l);
		PlayabilityDTO actualElements2 = playabilityRepository.find(1l);
		PlayabilityDTO actualElements3 = playabilityRepository.find(5l);
		// then
		assertEquals(BOARDGAME_ON_INDEX_3, actualElements1);
		assertEquals(BOARDGAME_ON_INDEX_0, actualElements2);
		assertEquals(BOARDGAME_ON_INDEX_4, actualElements3);
	}

	@Test
	public void shouldReturnNullWhenIdNotInRepository() {
		// when
		PlayabilityDTO actualElements = playabilityRepository.find(78L);
		// then
		assertNull(actualElements);
	}

	@Test
	public void shouldUpdateElement() {
		// given
		PlayabilityDTO expectedUpdatedEntity = new PlayabilityDTO(3l, userInfo4, new Date(2018, 2, 26, 13, 00),
				new Date(2018, 2, 26, 14, 00), "dentist", false);
		// when
		PlayabilityDTO playability = new PlayabilityDTO(3l, userInfo4, new Date(2018, 2, 26, 13, 00),
				new Date(2018, 2, 26, 14, 00), "dentist", false);
		playabilityRepository.update(playability);
		// then
		List<PlayabilityDTO> allElements = playabilityRepository.findAll();
		PlayabilityDTO actualElement = playabilityRepository.find(3L);
		assertEquals(INIT_BOARDGAME_SIZE, allElements.size());
		assertEquals(expectedUpdatedEntity, actualElement);
	}

	@Test
	public void shouldReturnTrueWhenElementIsSaved() {
		// given
		PlayabilityDTO expectedPlayability = new PlayabilityDTO(6l, userInfo4, new Date(2018, 2, 26, 13, 00),
				new Date(2018, 2, 26, 14, 00), "dentist", false);
		// when
		PlayabilityDTO playability = new PlayabilityDTO(null, userInfo4, new Date(2018, 2, 26, 13, 00),
				new Date(2018, 2, 26, 14, 00), "dentist", false);
		playabilityRepository.save(playability);

		// then
		List<PlayabilityDTO> allElements = playabilityRepository.findAll();
		assertEquals(6, allElements.size());
		assertEquals(expectedPlayability, allElements.get(allElements.size() - 1));
	}
}