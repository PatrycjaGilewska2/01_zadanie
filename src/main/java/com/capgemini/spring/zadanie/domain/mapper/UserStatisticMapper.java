package com.capgemini.spring.zadanie.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;
import com.capgemini.spring.zadanie.domain.entity.UserStatisticEntity;

public class UserStatisticMapper {

	public static UserStatisticDTO map(UserStatisticEntity userStatisticEntity) {
		if (userStatisticEntity == null) {
			return null;
		}

		UserStatisticDTO userStatisticDTO = new UserStatisticDTO();

		userStatisticDTO.setId(userStatisticEntity.getId());
		userStatisticDTO.setLevel(userStatisticEntity.getLevel());
		userStatisticDTO.setAmountOfCancelledGames(userStatisticEntity.getAmountOfCancelledGames());
		userStatisticDTO.setAmountOfPlayedGames(userStatisticEntity.getAmountOfPlayedGames());
		userStatisticDTO.setAmountOfOwnedGames(userStatisticEntity.getAmountOfOwnedGames());
		userStatisticDTO.setRankingPosition(userStatisticEntity.getRankingPosition());

		userStatisticDTO.setUser(UserInformationMapper.map(userStatisticEntity.getUser()));

		return userStatisticDTO;
	}

	public static UserStatisticEntity map(UserStatisticDTO userStatisticDTO) {
		if (userStatisticDTO == null) {
			return null;
		}

		UserStatisticEntity userStatisticEntity = new UserStatisticEntity();
		userStatisticEntity.setId(userStatisticDTO.getId());
		userStatisticEntity.setLevel(userStatisticDTO.getLevel());
		userStatisticEntity.setAmountOfCancelledGames(userStatisticDTO.getAmountOfCancelledGames());
		userStatisticEntity.setAmountOfPlayedGames(userStatisticDTO.getAmountOfPlayedGames());
		userStatisticEntity.setAmountOfOwnedGames(userStatisticDTO.getAmountOfOwnedGames());
		userStatisticEntity.setRankingPosition(userStatisticDTO.getRankingPosition());

		userStatisticEntity.setUser(UserInformationMapper.map(userStatisticDTO.getUser()));

		return userStatisticEntity;
	}

	public List<UserStatisticDTO> mapToDTOs(List<UserStatisticEntity> userStatisticEntities) {

		List<UserStatisticDTO> userStatisticDTOs = new ArrayList<>();

		for (UserStatisticEntity UserStatisticEntity : userStatisticEntities) {
			userStatisticDTOs.add(map(UserStatisticEntity));
		}
		return userStatisticDTOs;
	}

	public List<UserStatisticEntity> mapToEnitities(List<UserStatisticDTO> userStatisticDTOs) {

		List<UserStatisticEntity> userStatisticEntities = new ArrayList<>();

		for (UserStatisticDTO userStatisticDTO : userStatisticDTOs) {
			userStatisticEntities.add(map(userStatisticDTO));
		}
		return userStatisticEntities;
	}

}
