package com.capgemini.spring.zadanie.service.core.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalBoardGameException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.repository.BoardGameRepository;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;

@RunWith(MockitoJUnitRunner.class)
public class BoardGameManagementServiceImplTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	private BoardGameRepository boardGameService;

	@Mock
	private UserInformationRepository userInformationService;

	@InjectMocks
	private BoardGameManagementServiceImpl gameManagement;

	@Test
	public void shouldAddGameToUserCollection() throws InvalidUserException, IllegalBoardGameException {
		// given
		ArgumentCaptor<UserInformationDTO> captor = ArgumentCaptor.forClass(UserInformationDTO.class);

		Mockito.when(boardGameService.find(1L)).thenReturn(DataUtil.game6);
		Mockito.when(userInformationService.find(1L)).thenReturn(DataUtil.userInfo4);

		UserInformationDTO expectedUser = DataUtil.userInfo4;
		expectedUser.addGame(DataUtil.game6);
		// when
		gameManagement.addGameToUserCollection(1l, 1l);
		// then
		Mockito.verify(userInformationService).update(captor.capture());
		assertEquals(expectedUser, captor.getValue());
	}

	@Test
	public void shouldAddGameByItsName() throws IllegalBoardGameException {
		// given
		ArgumentCaptor<BoardGameDTO> captor = ArgumentCaptor.forClass(BoardGameDTO.class);
		BoardGameDTO expectedGame = new BoardGameDTO(null, "Szachy");
		// when
		gameManagement.addGame("Szachy");
		// then
		Mockito.verify(boardGameService).save(captor.capture());
		assertEquals(expectedGame, captor.getValue());
	}
	
	@Test
	public void shouldThrowExceptioWhenGameNameIsNull() throws IllegalBoardGameException {
		// expected
		thrown.expect(IllegalBoardGameException.class);
		thrown.expectMessage("Name cannot be null");
		// when
		gameManagement.addGame(null);
	}
	
	@Test
	public void shouldThrowExceptioWhenGameNameIsEmpty() throws IllegalBoardGameException {
		// expected
		thrown.expect(IllegalBoardGameException.class);
		thrown.expectMessage("Name cannot be empty");
		// when
		gameManagement.addGame("     ");
	}
	@Test
	public void shouldThrowExceptioWhenGameNameIsInDatabase() throws IllegalBoardGameException {
		//given
		Mockito.when(boardGameService.find("Szachy")).thenReturn(DataUtil.game6);
		// expected
		thrown.expect(IllegalBoardGameException.class);
		thrown.expectMessage("Name already in database");
		// when
		gameManagement.addGame("Szachy");
	}

	@Test
	public void shouldRemoveGameFromUserCollection() throws InvalidUserException, IllegalBoardGameException {
		// given
		ArgumentCaptor<UserInformationDTO> captor = ArgumentCaptor.forClass(UserInformationDTO.class);

		Mockito.when(boardGameService.find(1L)).thenReturn(DataUtil.game6);
		Mockito.when(userInformationService.find(1L)).thenReturn(DataUtil.userInfo4);

		UserInformationDTO expectedUser = DataUtil.userInfo4;
		expectedUser.removeGame(DataUtil.game6);
		// when
		gameManagement.removeGameFromUserCollection(1l, 1l);
		// then
		Mockito.verify(userInformationService).update(captor.capture());
		assertEquals(expectedUser, captor.getValue());
	}

	@Test
	public void shouldShowUserGames() throws InvalidUserException {
		//given
		ArrayList<BoardGameDTO> expectedBoardGames = new ArrayList<>(
				Arrays.asList(new BoardGameDTO[] { DataUtil.game6, DataUtil.game7 }));
		Mockito.when(userInformationService.find(1L)).thenReturn(DataUtil.userInfo4);
		//when
		List<BoardGameDTO> actualBoardGames = gameManagement.showUserGames(1l);
		//then
		assertEquals(expectedBoardGames, actualBoardGames);
	}
}
