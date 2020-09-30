package com.capgemini.spring.zadanie.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.entity.UserInformationEntity;
import com.capgemini.spring.zadanie.domain.mapper.UserInformationMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;

public class UserInformationRepositoryImplTest {

	private UserInformationRepository userInformationRepository;

	private final UserInformationDTO USER_ON_INDEX_1 = UserInformationMapper.map(DataUtil.userInfo1);
	private final UserInformationDTO USER_ON_LAST_INDEX = UserInformationMapper.map(DataUtil.userInfo3);

	@Before
	public void init() {
		userInformationRepository = new UserInformationRepositoryImpl();
	}

	@Test
	public void shouldFindCorrecElementById() {
		// when
		UserInformationDTO actualElements1 = userInformationRepository.find(1l);
		UserInformationDTO actualElements2 = userInformationRepository.find(3l);
		// then
		assertEquals(USER_ON_INDEX_1, actualElements1);
		assertEquals(USER_ON_LAST_INDEX, actualElements2);
	}

	@Test
	public void shouldReturnNullWhenIdNotInRepository() {
		// when
		UserInformationDTO actualElements = userInformationRepository.find(78L);
		// then
		assertNull(actualElements);
	}

	@Test
	public void shouldUpdateElement() {
		// given
		UserInformationEntity expectedUpdatedEntity = new UserInformationEntity(3l, "Jan", "Trabalski",
				"janeczek18@gmail.com", "Janeczek18", "Be Yourself", new ArrayList<>());
		// when
		userInformationRepository.update(new UserInformationDTO(3l, "Jan", "Trabalski", "janeczek18@gmail.com",
				"Janeczek18", "Be Yourself", new ArrayList<>()));
		// then
		UserInformationEntity actualElement = UserInformationMapper.map(userInformationRepository.find(3l));
		assertEquals(expectedUpdatedEntity, actualElement);
	}
}
