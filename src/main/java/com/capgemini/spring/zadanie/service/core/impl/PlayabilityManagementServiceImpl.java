package com.capgemini.spring.zadanie.service.core.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalPlayabilityException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;
import com.capgemini.spring.zadanie.repository.PlayabilityRepository;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;
import com.capgemini.spring.zadanie.service.core.PlayabilityManagementService;
import com.capgemini.spring.zadanie.service.validation.ValidationService;

@Service
public class PlayabilityManagementServiceImpl implements PlayabilityManagementService {

	@Autowired
	private ValidationService validationService;

	@Autowired
	private PlayabilityRepository playabilityService;

	@Autowired
	private UserInformationRepository userInformationService;

	@Override
	public void addPlayability(Long userId, Date startDate, Date endDate)
			throws InvalidUserException, IllegalPlayabilityException {
		validationService.validateDates(startDate, endDate);
		validationService.validateUser(userId);
		UserInformationDTO user = userInformationService.find(userId);
		PlayabilityDTO playabilityToAdd = new PlayabilityDTO(null, user, startDate, endDate, null, true);
		playabilityService.save(playabilityToAdd);
	}

	@Override
	public void updatePlayability(Long playabilityId, Date startDate, Date endDate) throws IllegalPlayabilityException {
		validationService.validateDates(startDate, endDate);
		validationService.validatePlayability(playabilityId);
		PlayabilityDTO playability = playabilityService.find(playabilityId);
		if (!playability.isActual()) {
			throw new IllegalPlayabilityException("Cannot cancel already cancelled playability");
		}
		playability.setStartDate(startDate);
		playability.setEndDate(endDate);
		playabilityService.update(playability);
	}

	@Override
	public void cancelPlayability(Long playabilityId, String comment) throws IllegalPlayabilityException {
		validationService.validatePlayability(playabilityId);
		PlayabilityDTO playability = playabilityService.find(playabilityId);
		if (!playability.isActual()) {
			throw new IllegalPlayabilityException("Cannot cancel already cancelled playability");
		}
		playability.setActual(false);
		playability.setComment(comment);
		playabilityService.update(playability);
	}

	@Override
	public List<PlayabilityDTO> findSimiliarPlayabilities(PlayabilityDTO playability)
			throws IllegalPlayabilityException {
		if (!playability.isActual()) {
			throw new IllegalPlayabilityException("Cannot find similar playabilities to already cancelled playability");
		}
		validationService.validateDates(playability.getStartDate(), playability.getEndDate());
		List<PlayabilityDTO> playabilities = playabilityService.findAll();
		List<PlayabilityDTO> filteredList = playabilities.stream().filter(element -> {
			UserInformationDTO user = playability.getUser();
			return element.isActual() && !element.getUser().equals(user)
					&& playability.getStartDate().compareTo(element.getStartDate()) <= 0
					&& playability.getEndDate().compareTo(element.getEndDate()) >= 0;
		}).collect(Collectors.toList());
		return filteredList;
	}
}
