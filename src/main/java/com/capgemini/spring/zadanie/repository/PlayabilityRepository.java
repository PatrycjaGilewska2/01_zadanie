package com.capgemini.spring.zadanie.repository;

import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;

public interface PlayabilityRepository {

	public List<PlayabilityDTO> findAll();

	public PlayabilityDTO find(Long id);

	public void save(PlayabilityDTO playability);

	public void update(PlayabilityDTO playability);
}
