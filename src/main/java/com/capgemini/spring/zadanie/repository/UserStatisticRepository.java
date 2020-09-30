package com.capgemini.spring.zadanie.repository;

import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;

public interface UserStatisticRepository {
	
	public UserStatisticDTO findByUserId(Long userId);
	
}
