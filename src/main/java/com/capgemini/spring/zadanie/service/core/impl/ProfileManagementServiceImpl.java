package com.capgemini.spring.zadanie.service.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;
import com.capgemini.spring.zadanie.repository.UserStatisticRepository;
import com.capgemini.spring.zadanie.service.core.ProfileManagementService;
import com.capgemini.spring.zadanie.service.validation.ValidationService;

@Service
public class ProfileManagementServiceImpl implements ProfileManagementService {

	@Autowired
	private ValidationService validationService;

	@Autowired
	private UserStatisticRepository userStatisticService;

	@Autowired
	private UserInformationRepository userInformationService;

	@Override
	public UserInformationDTO showUserInformation(Long userId) throws InvalidUserException {
		validationService.validateUser(userId);
		UserInformationDTO user = userInformationService.find(userId);
		return user;
	}

	@Override
	public void editUserInformation(UserInformationDTO userInformation) throws InvalidUserException {
		validationService.validateUserInformation(userInformation);
		UserInformationDTO userInfo = userInformationService.find(userInformation.getId());
		userInformation.setOwnedGames(userInfo.getOwnedGames());
		userInformationService.update(userInformation);
	}

	@Override
	public UserStatisticDTO showStatistic(Long userId) throws InvalidUserException {
		validationService.validateUser(userId);
		UserInformationDTO user = userInformationService.find(userId);
		return userStatisticService.findByUserId(userId);
	}

	@Override
	public List<UserInformationDTO> findUsers(String firstName, String lastName, String email) {
		List<UserInformationDTO> result = new ArrayList<>();
		List<UserInformationDTO> allUsers = userInformationService.findAll();
		for (UserInformationDTO userInformationDTO : allUsers) {
			if (userInformationDTO.getFirstName().equals(firstName) || userInformationDTO.getLastName().equals(lastName)
					|| userInformationDTO.getEmail().equals(email)) {
				result.add(userInformationDTO);
			}
		}
		return result;
	}
}
