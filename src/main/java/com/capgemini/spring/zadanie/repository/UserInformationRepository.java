package com.capgemini.spring.zadanie.repository;

import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;

public interface UserInformationRepository {

	public UserInformationDTO find(Long id);

	public void update(UserInformationDTO userInfo);

	public List<UserInformationDTO> findAll();
}
