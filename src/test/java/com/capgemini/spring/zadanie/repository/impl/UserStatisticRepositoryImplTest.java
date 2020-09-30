package com.capgemini.spring.zadanie.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;
import com.capgemini.spring.zadanie.domain.mapper.UserStatisticMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.UserStatisticRepository;

public class UserStatisticRepositoryImplTest {

	private UserStatisticRepository userStatisticRepository;
	private final UserStatisticDTO STATISTIC1 = UserStatisticMapper.map(DataUtil.userStatistic1);
	private final UserStatisticDTO STATISTIC3 = UserStatisticMapper.map(DataUtil.userStatistic3);

	@Before
	public void init() {
		userStatisticRepository = new UserStatisticRepositoryImpl();
	}

	@Test
	public void shouldFindElementById() {
		// when
		UserStatisticDTO actualElements1 = userStatisticRepository.findByUserId(1l);
		UserStatisticDTO actualElements3 = userStatisticRepository.findByUserId(3l);
		// then
		assertEquals(STATISTIC1, actualElements1);
		assertEquals(STATISTIC3, actualElements3);
	}

	@Test
	public void shouldReturnNullWhenIdNotInRepository() {
		// when
		UserStatisticDTO actualElements = userStatisticRepository.findByUserId(78l);
		// then
		assertNull(actualElements);
	}
}
