package com.capgemini.spring.zadanie.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.entity.UserInformationEntity;
import com.capgemini.spring.zadanie.domain.mapper.UserInformationMapper;
import com.capgemini.spring.zadanie.repository.DataUtil;
import com.capgemini.spring.zadanie.repository.UserInformationRepository;

@Repository
public class UserInformationRepositoryImpl implements UserInformationRepository {

	private List<UserInformationEntity> userInfos = new ArrayList<>();

	public UserInformationRepositoryImpl() {
		userInfos.add(DataUtil.userInfo1);
		userInfos.add(DataUtil.userInfo2);
		userInfos.add(DataUtil.userInfo3);
	}

	@Override
	public List<UserInformationDTO> findAll() {
		return UserInformationMapper.mapToDTOs(userInfos);
	}

	@Override
	public UserInformationDTO find(Long id) {
		for (UserInformationEntity userInformationEntity : userInfos) {
			if (userInformationEntity.getId() == id) {
				return UserInformationMapper.map(userInformationEntity);
			}
		}
		return null;
	}

	@Override
	public void update(UserInformationDTO userInfoToUpdate) {

		UserInformationEntity userInfo = UserInformationMapper.map(userInfoToUpdate);
		int index = userInfos.indexOf(UserInformationMapper.map(find(userInfo.getId())));
		userInfos.set(index, userInfo);

	}
}
