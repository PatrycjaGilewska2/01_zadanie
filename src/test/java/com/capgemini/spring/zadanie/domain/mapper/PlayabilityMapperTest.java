package com.capgemini.spring.zadanie.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.entity.PlayabilityEntity;
import com.capgemini.spring.zadanie.repository.DataUtil;

public class PlayabilityMapperTest {

	@Test
	public void shouldReturnCorrectEntity() {
		// given
		PlayabilityEntity expectedEntity = new PlayabilityEntity(1l, DataUtil.userInfo1, new Date(2018, 2, 25, 13, 00),
				new Date(2018, 2, 25, 14, 00), null, true);

		PlayabilityDTO dto = new PlayabilityDTO(1l, DataUtil.userInfo4, new Date(2018, 2, 25, 13, 00),
				new Date(2018, 2, 25, 14, 00), null, true);
		// when
		PlayabilityEntity actual = PlayabilityMapper.map(dto);
		// then
		assertEquals(expectedEntity, actual);
	}

	@Test
	public void shouldReturnCorrectDTO() {
		// given
		PlayabilityEntity entity = new PlayabilityEntity(1l, DataUtil.userInfo1, new Date(2018, 2, 25, 13, 00),
				new Date(2018, 2, 25, 14, 00), null, true);
		PlayabilityDTO expectedDTO = new PlayabilityDTO(1l, DataUtil.userInfo4, new Date(2018, 2, 25, 13, 00),
				new Date(2018, 2, 25, 14, 00), null, true);
		// when
		PlayabilityDTO actual = PlayabilityMapper.map(entity);
		// then
		assertEquals(expectedDTO, actual);
	}
}
