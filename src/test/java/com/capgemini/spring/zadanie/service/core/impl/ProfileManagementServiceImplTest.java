package com.capgemini.spring.zadanie.service.core.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProfileManagementServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	private UserInformationRepository userInformationService;

	@InjectMocks
	private ProfileManagementServiceImpl profileManager;

	@Test
	public void shouldThrowExceptionWhenFirstNameIsEmpty() throws InvalidUserException {
		// expected
		thrown.expect(InvalidUserException.class);
		thrown.expectMessage("First name cannot be empty");
		// given
		UserInformationDTO userToUpdate = new UserInformationDTO(1L, " ", "", "", "", "", new ArrayList<>());
		// when
		profileManager.editUserInformation(userToUpdate);
	}

	@Test
	public void shouldThrowExceptionWhenLastNameIsEmpty() throws InvalidUserException {
		// expected
		thrown.expect(InvalidUserException.class);
		thrown.expectMessage("Last name cannot be empty");
		// given
		UserInformationDTO userToUpdate = new UserInformationDTO(1L, "Andrzej", "", "", "", "", new ArrayList<>());
		// when
		profileManager.editUserInformation(userToUpdate);
	}

	@Test
	public void shouldThrowExceptionWhenEmailIsInvalid() throws InvalidUserException {
		// expected
		thrown.expect(InvalidUserException.class);
		thrown.expectMessage("Email is invalid");
		// given
		UserInformationDTO userToUpdate = new UserInformationDTO(1L, "Andrzej", "Strzelba", "dsadsa", "dsadsadsa", "",
				new ArrayList<>());
		// when
		profileManager.editUserInformation(userToUpdate);
	}

	@Test
	public void shouldThrowExceptionWhenPasswordIsEmpty() throws InvalidUserException {
		// expected
		thrown.expect(InvalidUserException.class);
		thrown.expectMessage("Password cannot be empty");
		// given
		UserInformationDTO userToUpdate = new UserInformationDTO(1L, "Andrzej", "Strzelba",
				"andrzej.strzelba@gmail.com", "", "", new ArrayList<>());
		// when
		profileManager.editUserInformation(userToUpdate);
	}

	@Test
	public void shouldUpdateUserInformationExceptOwnedGames() throws InvalidUserException {
		// given
		Mockito.when(userInformationService.find(1L)).thenReturn(DataUtil.userInfo4);
		ArgumentCaptor<UserInformationDTO> captor = ArgumentCaptor.forClass(UserInformationDTO.class);

		UserInformationDTO userToUpdate = new UserInformationDTO(1L, "Andrzej", "Strzelba",
				"andrzej.strzelba@gmail.com", "dsadsadsadsa", "", new ArrayList<>());
		UserInformationDTO expected = new UserInformationDTO(1L, "Andrzej", "Strzelba", "andrzej.strzelba@gmail.com",
				"dsadsadsadsa", "", DataUtil.userInfo4.getOwnedGames());
		// when
		profileManager.editUserInformation(userToUpdate);
		// then
		Mockito.verify(userInformationService).update(captor.capture());
		assertEquals(expected, captor.getValue());
	}
}
