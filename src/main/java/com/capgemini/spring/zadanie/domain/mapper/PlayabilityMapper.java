package com.capgemini.spring.zadanie.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.entity.PlayabilityEntity;

public class PlayabilityMapper {

	public static PlayabilityEntity map(PlayabilityDTO playabilityDTO) {
		if (playabilityDTO == null) {
			return null;
		}

		PlayabilityEntity playabilityEntity = new PlayabilityEntity();

		playabilityEntity.setId(playabilityDTO.getId());
		playabilityEntity.setStartDate(playabilityDTO.getStartDate());
		playabilityEntity.setEndDate(playabilityDTO.getEndDate());
		playabilityEntity.setComment(playabilityDTO.getComment());
		playabilityEntity.setActual(playabilityDTO.isActual());

		playabilityEntity.setUser(UserInformationMapper.map(playabilityDTO.getUser()));

		return playabilityEntity;
	}

	public static PlayabilityDTO map(PlayabilityEntity playabilityEntity) {
		if (playabilityEntity == null) {
			return null;
		}

		PlayabilityDTO playabilityDTO = new PlayabilityDTO();
		playabilityDTO.setId(playabilityEntity.getId());
		playabilityDTO.setStartDate(playabilityEntity.getStartDate());
		playabilityDTO.setEndDate(playabilityEntity.getEndDate());
		playabilityDTO.setComment(playabilityEntity.getComment());
		playabilityDTO.setActual(playabilityEntity.isActual());

		playabilityDTO.setUser(UserInformationMapper.map(playabilityEntity.getUser()));

		return playabilityDTO;
	}

	public static List<PlayabilityDTO> mapToDTOs(List<PlayabilityEntity> playabilityEntities) {

		List<PlayabilityDTO> playabilityDTO = new ArrayList<>();

		for (PlayabilityEntity playabilityEntity : playabilityEntities) {
			playabilityDTO.add(map(playabilityEntity));
		}
		return playabilityDTO;
	}

	public static List<PlayabilityEntity> mapToEntities(List<PlayabilityDTO> playabilityDTOs) {

		List<PlayabilityEntity> playabilityEntity = new ArrayList<>();

		for (PlayabilityDTO playabilityDTO : playabilityDTOs) {
			playabilityEntity.add(map(playabilityDTO));
		}
		return playabilityEntity;
	}
}