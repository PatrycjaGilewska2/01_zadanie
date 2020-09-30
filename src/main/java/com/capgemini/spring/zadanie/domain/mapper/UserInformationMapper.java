package com.capgemini.spring.zadanie.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.entity.UserInformationEntity;

public class UserInformationMapper {

	public static UserInformationEntity map(UserInformationDTO userInformationDTO) {
		if (userInformationDTO == null) {
			return null;
		}

		UserInformationEntity userInformationEntity = new UserInformationEntity();

		userInformationEntity.setId(userInformationDTO.getId());
		userInformationEntity.setFirstName(userInformationDTO.getFirstName());
		userInformationEntity.setLastName(userInformationDTO.getLastName());
		userInformationEntity.setEmail(userInformationDTO.getEmail());
		userInformationEntity.setPassword(userInformationDTO.getPassword());
		userInformationEntity.setLifeMotto(userInformationDTO.getLifeMotto());
		userInformationEntity.setOwnedGames(BoardGameMapper.mapToEntities(userInformationDTO.getOwnedGames()));

		return userInformationEntity;
	}

	public static UserInformationDTO map(UserInformationEntity userInformationEntity) {
		if (userInformationEntity == null) {
			return null;
		}

		UserInformationDTO userInformationDTO = new UserInformationDTO();

		userInformationDTO.setId(userInformationEntity.getId());
		userInformationDTO.setFirstName(userInformationEntity.getFirstName());
		userInformationDTO.setLastName(userInformationEntity.getLastName());
		userInformationDTO.setEmail(userInformationEntity.getEmail());
		userInformationDTO.setPassword(userInformationEntity.getPassword());
		userInformationDTO.setLifeMotto(userInformationEntity.getLifeMotto());
		userInformationDTO.setOwnedGames(BoardGameMapper.mapToDTOs(userInformationEntity.getOwnedGames()));

		return userInformationDTO;
	}

	public static List<UserInformationEntity> mapToEntities(List<UserInformationDTO> userInformationDTOs) {

		List<UserInformationEntity> userInformationEntities = new ArrayList<>();

		for (UserInformationDTO userInformationDTO : userInformationDTOs) {
			userInformationEntities.add(map(userInformationDTO));
		}

		return userInformationEntities;
	}

	public static List<UserInformationDTO> mapToDTOs(List<UserInformationEntity> UserInformationEntities) {

		List<UserInformationDTO> userInformationDTOs = new ArrayList<>();

		for (UserInformationEntity userInformationEntity : UserInformationEntities) {
			userInformationDTOs.add(map(userInformationEntity));
		}

		return userInformationDTOs;
	}
}
