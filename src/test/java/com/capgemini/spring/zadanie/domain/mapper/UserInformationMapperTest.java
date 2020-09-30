package com.capgemini.spring.zadanie.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.entity.BoardGameEntity;
import com.capgemini.spring.zadanie.domain.entity.UserInformationEntity;
import com.capgemini.spring.zadanie.repository.DataUtil;

public class UserInformationMapperTest {

	@Test
	public void shouldReturnCorrectEntity() {
		// given
		UserInformationEntity expectedEntity = new UserInformationEntity(1l, "Katarzyna", "Kowalska",
				"katarzynaka@gmail.com", "Katarzyna123", "Carpe Diem",
				new ArrayList<>(Arrays.asList(new BoardGameEntity[] { DataUtil.game1, DataUtil.game3 })));
		UserInformationDTO dto = new UserInformationDTO(1l, "Katarzyna", "Kowalska", "katarzynaka@gmail.com",
				"Katarzyna123", "Carpe Diem",
				new ArrayList<>(Arrays.asList(new BoardGameDTO[] { DataUtil.game6, DataUtil.game7 })));
		// when
		UserInformationEntity actual = UserInformationMapper.map(dto);
		// then
		assertEquals(expectedEntity, actual);
	}

	@Test
	public void shouldReturnCorrectDTO() {
		// given
		UserInformationEntity entity = new UserInformationEntity(1l, "Katarzyna", "Kowalska", "katarzynaka@gmail.com",
				"Katarzyna123", "Carpe Diem",
				new ArrayList<>(Arrays.asList(new BoardGameEntity[] { DataUtil.game1, DataUtil.game3 })));
		UserInformationDTO expectedDTO = new UserInformationDTO(1l, "Katarzyna", "Kowalska", "katarzynaka@gmail.com",
				"Katarzyna123", "Carpe Diem",
				new ArrayList<>(Arrays.asList(new BoardGameDTO[] { DataUtil.game6, DataUtil.game7 })));
		// when
		UserInformationDTO actual = UserInformationMapper.map(entity);
		// then
		assertEquals(expectedDTO, actual);
	}
}
