package com.capgemini.spring.zadanie.service.core.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalPlayabilityException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.domain.mapper.PlayabilityMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.PlayabilityRepository;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;

@RunWith(MockitoJUnitRunner.class)
public class PlayabilityManagementServiceImplTest {

	@Mock
	private PlayabilityRepository playabilityService;

	@Mock
	private UserInformationRepository userInformationService;

	@InjectMocks
	PlayabilityManagementServiceImpl playabilityManagement;

	@Test
	public void shouldAddPlayability() throws InvalidUserException, IllegalPlayabilityException {
		// given
		ArgumentCaptor<PlayabilityDTO> captor = ArgumentCaptor.forClass(PlayabilityDTO.class);
		PlayabilityDTO expectedPlayability = new PlayabilityDTO(null, DataUtil.userInfo4, new Date(2018, 2, 25, 13, 00),
				new Date(2018, 2, 25, 14, 00), null, true);
		Mockito.when(userInformationService.find(1L)).thenReturn(DataUtil.userInfo4);
		// when
		playabilityManagement.addPlayability(1l, new Date(2018, 2, 25, 13, 00), new Date(2018, 2, 25, 14, 00));
		// then
		Mockito.verify(playabilityService).save(captor.capture());
		assertEquals(expectedPlayability, captor.getValue());
	}

	@Test
	public void shouldUpdatePlayability() throws IllegalPlayabilityException {
		// given
		ArgumentCaptor<PlayabilityDTO> captor = ArgumentCaptor.forClass(PlayabilityDTO.class);
		PlayabilityDTO expectedPlayability = new PlayabilityDTO(1l, DataUtil.userInfo4, new Date(2018, 2, 26, 13, 00),
				new Date(2018, 2, 26, 14, 00), null, true);
		Mockito.when(playabilityService.find(1L)).thenReturn(DataUtil.playability6);
		// when
		playabilityManagement.updatePlayability(1l, new Date(2018, 2, 26, 13, 00), new Date(2018, 2, 26, 14, 00));
		// then
		Mockito.verify(playabilityService).update(captor.capture());
		assertEquals(expectedPlayability, captor.getValue());
	}

	@Test
	public void shouldCancelPlayability() throws IllegalPlayabilityException {
		// given
		ArgumentCaptor<PlayabilityDTO> captor = ArgumentCaptor.forClass(PlayabilityDTO.class);
		PlayabilityDTO expectedPlayability = new PlayabilityDTO(1l, DataUtil.userInfo4, new Date(2018, 2, 25, 13, 00),
				new Date(2018, 2, 25, 14, 00), "busy", false);
		Mockito.when(playabilityService.find(1L)).thenReturn(DataUtil.playability7);
		// when
		playabilityManagement.cancelPlayability(1l, "busy");
		// then
		Mockito.verify(playabilityService).update(captor.capture());
		assertEquals(expectedPlayability, captor.getValue());
	}

	@Test
	public void shouldReturnOneSimilarPlayability() throws IllegalPlayabilityException {
		// given
		Mockito.when(playabilityService.findAll()).thenReturn(DataUtil.playabilities);
		List<PlayabilityDTO> expected = new ArrayList<>();
		expected.add(PlayabilityMapper.map(DataUtil.playability4));
		// when
		List<PlayabilityDTO> actual = playabilityManagement
				.findSimiliarPlayabilities(PlayabilityMapper.map(DataUtil.playability1));
		// then
		assertEquals(expected, actual);
	}
}
