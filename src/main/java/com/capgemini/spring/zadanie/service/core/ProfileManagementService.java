package com.capgemini.spring.zadanie.service.core;

import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;

public interface ProfileManagementService {
	
	public UserInformationDTO showUserInformation(Long userId) throws InvalidUserException;
	
	public void editUserInformation(UserInformationDTO userInformation) throws InvalidUserException;

	public UserStatisticDTO showStatistic(Long userId) throws InvalidUserException;

	public List<UserInformationDTO> findUsers(String firstName, String lastName, String email);
	
}
