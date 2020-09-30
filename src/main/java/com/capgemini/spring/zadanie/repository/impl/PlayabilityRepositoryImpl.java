package com.capgemini.spring.zadanie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.entity.PlayabilityEntity;
import com.capgemini.spring.zadanie.domain.mapper.PlayabilityMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.PlayabilityRepository;

@Repository
public class PlayabilityRepositoryImpl implements PlayabilityRepository {

	private List<PlayabilityEntity> playabilities = new ArrayList<>();

	public PlayabilityRepositoryImpl() {
		playabilities.add(DataUtil.playability1);
		playabilities.add(DataUtil.playability2);
		playabilities.add(DataUtil.playability3);
		playabilities.add(DataUtil.playability4);
		playabilities.add(DataUtil.playability5);
	}

	@Override
	public List<PlayabilityDTO> findAll() {
		return PlayabilityMapper.mapToDTOs(playabilities);
	}

	@Override
	public PlayabilityDTO find(Long id) {
		for (PlayabilityEntity playabilityEntity : playabilities) {
			if (playabilityEntity.getId() == id) {
				return PlayabilityMapper.map(playabilityEntity);
			}
		}
		return null;
	}

	@Override
	public void save(PlayabilityDTO playabilityToSave) {
		PlayabilityEntity playability = PlayabilityMapper.map(playabilityToSave);
		playability.setId(getNextId());
		playabilities.add(playability);
	}

	@Override
	public void update(PlayabilityDTO playabilityToUpdate) {
		PlayabilityEntity playability = PlayabilityMapper.map(playabilityToUpdate);
		int index = playabilities.indexOf(PlayabilityMapper.map(find(playability.getId())));
		playabilities.set(index, playability);
	}

	private long getNextId() {
		long maxId = Long.MIN_VALUE;
		for (PlayabilityEntity playabilityEntity : playabilities) {
			if (playabilityEntity.getId() > maxId) {
				maxId = playabilityEntity.getId();
			}
		}
		return ++maxId;
	}
}
