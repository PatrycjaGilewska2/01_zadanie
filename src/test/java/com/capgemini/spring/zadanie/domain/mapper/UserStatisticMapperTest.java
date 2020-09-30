package com.capgemini.spring.zadanie.domain.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;
import com.capgemini.spring.zadanie.domain.entity.UserStatisticEntity;
import com.capgemini.spring.zadanie.domain.enums.Level;
import com.capgemini.spring.zadanie.repository.DataUtil;

public class UserStatisticMapperTest {

	@Test
	public void shouldReturnCorrectEntity() {
		// given
		UserStatisticEntity expectedEntity = new UserStatisticEntity(1l, DataUtil.userInfo1, Level.BEGGINER, 2l,
				1l, 1l, 2l);
		UserStatisticDTO dto = new UserStatisticDTO(1l, DataUtil.userInfo4, Level.BEGGINER, 2l, 1l, 1l, 2l);
		// when
		UserStatisticEntity actual = UserStatisticMapper.map(dto);
		// then
		assertEquals(expectedEntity, actual);
	}

	@Test
	public void shouldReturnCorrectDTO() {
		// given
		UserStatisticEntity entity = new UserStatisticEntity(1l, DataUtil.userInfo1, Level.BEGGINER, 2l, 1l, 1l, 2l);
		UserStatisticDTO expectedDTO = new UserStatisticDTO(1l, DataUtil.userInfo4, Level.BEGGINER, 2l, 1l, 1l, 2l);
		// when
		UserStatisticDTO actual = UserStatisticMapper.map(entity);
		// then
		assertEquals(expectedDTO, actual);
	}
}
