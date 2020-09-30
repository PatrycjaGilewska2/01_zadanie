package com.capgemini.spring.zadanie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.spring.zadanie.domain.dto.UserStatisticDTO;
import com.capgemini.spring.zadanie.domain.entity.UserStatisticEntity;
import com.capgemini.spring.zadanie.domain.mapper.UserStatisticMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.UserStatisticRepository;

@Repository
public class UserStatisticRepositoryImpl implements UserStatisticRepository {

	private List<UserStatisticEntity> userStatistics = new ArrayList<>();

	public UserStatisticRepositoryImpl() {
		userStatistics.add(DataUtil.userStatistic1);
		userStatistics.add(DataUtil.userStatistic2);
		userStatistics.add(DataUtil.userStatistic3);
	}

	@Override
	public UserStatisticDTO findByUserId(Long userId) {

		for (UserStatisticEntity userStatistic : userStatistics) {
			if (userStatistic.getUser().getId() == userId) {
				return UserStatisticMapper.map(userStatistic);
			}
		}
		return null;
	}
}
