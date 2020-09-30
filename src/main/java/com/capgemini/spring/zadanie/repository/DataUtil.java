package com.capgemini.spring.zadanie.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.domain.dto.PlayabilityDTO;
import com.capgemini.spring.zadanie.domain.dto.UserInformationDTO;
import com.capgemini.spring.zadanie.domain.entity.BoardGameEntity;
import com.capgemini.spring.zadanie.domain.entity.PlayabilityEntity;
import com.capgemini.spring.zadanie.domain.entity.UserInformationEntity;
import com.capgemini.spring.zadanie.domain.entity.UserStatisticEntity;
import com.capgemini.spring.zadanie.domain.enums.Level;
import com.capgemini.spring.zadanie.domain.mapper.PlayabilityMapper;

public class DataUtil {

	// games
	public static BoardGameEntity game1 = new BoardGameEntity(1l, "Taboo");
	public static BoardGameEntity game2 = new BoardGameEntity(2l, "Zgadnij kim jestem");
	public static BoardGameEntity game3 = new BoardGameEntity(3l, "Scrabble");
	public static BoardGameEntity game4 = new BoardGameEntity(4l, "Yenga");
	public static BoardGameEntity game5 = new BoardGameEntity(5l, "Chinczyk");

	public static BoardGameDTO game6 = new BoardGameDTO(1l, "Taboo");
	public static BoardGameDTO game7 = new BoardGameDTO(3l, "Scrabble");

	// user information
	public static UserInformationEntity userInfo1 = new UserInformationEntity(1l, "Katarzyna", "Kowalska",
			"katarzynaka@gmail.com", "Katarzyna123", "Carpe Diem",
			new ArrayList<>(Arrays.asList(new BoardGameEntity[] { game1, game3 })));
	public static UserInformationEntity userInfo2 = new UserInformationEntity(2l, "Anna", "Nowak", "annanowak@wp.pl",
			"12345", "Co masz zrobic dzisiaj, zrob jutro",
			new ArrayList<>(Arrays.asList(new BoardGameEntity[] { game1, game4 })));
	public static UserInformationEntity userInfo3 = new UserInformationEntity(3l, "Jan", "Trabalski",
			"janeczek18@gmail.com", "Janeczek18", "Be Free", new ArrayList<>());

	public static UserInformationDTO userInfo4 = new UserInformationDTO(1l, "Katarzyna", "Kowalska",
			"katarzynaka@gmail.com", "Katarzyna123", "Carpe Diem",
			new ArrayList<>(Arrays.asList(new BoardGameDTO[] { game6, game7 })));

	// user statistic
	public static UserStatisticEntity userStatistic1 = new UserStatisticEntity(1l, userInfo1, Level.BEGGINER, 2l, 1l,
			1l, 2l);
	public static UserStatisticEntity userStatistic2 = new UserStatisticEntity(2l, userInfo2, Level.NOOBE, 3l, 0l, 0l,
			2l);
	public static UserStatisticEntity userStatistic3 = new UserStatisticEntity(3l, userInfo3, Level.PRE_INTERMEDIATE,
			1l, 2l, 1l, 0l);

	// playability
	public static PlayabilityEntity playability1 = new PlayabilityEntity(1l, userInfo1, new Date(2018, 2, 25, 13, 00),
			new Date(2018, 2, 25, 14, 00), null, true);
	public static PlayabilityEntity playability2 = new PlayabilityEntity(2l, userInfo1, new Date(2018, 2, 25, 12, 00),
			new Date(2018, 2, 25, 13, 00), "dentist", false);
	public static PlayabilityEntity playability3 = new PlayabilityEntity(3l, userInfo3, new Date(2018, 2, 25, 12, 00),
			new Date(2018, 2, 25, 13, 00), "dentist", false);
	public static PlayabilityEntity playability4 = new PlayabilityEntity(4l, userInfo3, new Date(2018, 2, 25, 13, 10),
			new Date(2018, 2, 25, 14, 00), null, true);
	public static PlayabilityEntity playability5 = new PlayabilityEntity(5l, userInfo3, new Date(2018, 2, 26, 12, 00),
			new Date(2018, 2, 26, 14, 00), null, true);

	public static PlayabilityDTO playability6 = new PlayabilityDTO(1l, userInfo4, new Date(2018, 2, 25, 13, 00),
			new Date(2018, 2, 25, 14, 00), null, true);
	public static PlayabilityDTO playability7 = new PlayabilityDTO(1l, userInfo4, new Date(2018, 2, 25, 13, 00),
			new Date(2018, 2, 25, 14, 00), null, true);

	public static List<PlayabilityDTO> playabilities = PlayabilityMapper.mapToDTOs(new ArrayList<>(Arrays
			.asList(new PlayabilityEntity[] { playability1, playability2, playability3, playability4, playability5 })));

}