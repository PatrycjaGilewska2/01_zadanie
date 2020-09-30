package com.capgemini.spring.zadanie.service.core;

import java.util.Date;
import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.exception.IllegalPlayabilityException;
import com.capgemini.spring.zadanie.domain.exception.InvalidUserException;

public interface PlayabilityManagementService {

	public void addPlayability(Long userId, Date startDate, Date endDate) throws InvalidUserException, IllegalPlayabilityException;
	
	public void updatePlayability(Long playabilityId, Date startDate, Date endDate) throws IllegalPlayabilityException;

	public void cancelPlayability(Long playabilityId, String comment) throws IllegalPlayabilityException;  

	public List<PlayabilityDTO> findSimiliarPlayabilities(PlayabilityDTO playability) throws IllegalPlayabilityException;
}
