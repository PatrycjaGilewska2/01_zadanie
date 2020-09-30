package com.capgemini.spring.zadanie.domain.dto;

import com.capgemini.spring.zadanie.domain.enums.Level;

public class UserStatisticDTO {

	private Long id;
	private UserInformationDTO user;
	private Level level;
	private Long rankingPosition;
	private Long amountOfPlayedGames;
	private Long amountOfCancelledGames;
	private Long amountOfOwnedGames;

	public UserStatisticDTO() {
	}

	public UserStatisticDTO(Long id, UserInformationDTO user, Level level, Long rankingPosition,
			Long amountOfPlayedGames, Long amountOfCancelledGames, Long amountOfOwnedGames) {
		this.id = id;
		this.user = user;
		this.level = level;
		this.rankingPosition = rankingPosition;
		this.amountOfPlayedGames = amountOfPlayedGames;
		this.amountOfCancelledGames = amountOfCancelledGames;
		this.amountOfOwnedGames = amountOfOwnedGames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public UserInformationDTO getUser() {
		return user;
	}

	public void setUser(UserInformationDTO user) {
		this.user = user;
	}

	public Long getRankingPosition() {
		return rankingPosition;
	}

	public void setRankingPosition(Long rankingPosition) {
		this.rankingPosition = rankingPosition;
	}

	public Long getAmountOfPlayedGames() {
		return amountOfPlayedGames;
	}

	public void setAmountOfPlayedGames(Long amountOfPlayedGames) {
		this.amountOfPlayedGames = amountOfPlayedGames;
	}

	public Long getAmountOfCancelledGames() {
		return amountOfCancelledGames;
	}

	public void setAmountOfCancelledGames(Long amountOfCancelledGames) {
		this.amountOfCancelledGames = amountOfCancelledGames;
	}

	public Long getAmountOfOwnedGames() {
		return amountOfOwnedGames;
	}

	public void setAmountOfOwnedGames(Long amountOfOwnedGames) {
		this.amountOfOwnedGames = amountOfOwnedGames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOfCancelledGames == null) ? 0 : amountOfCancelledGames.hashCode());
		result = prime * result + ((amountOfOwnedGames == null) ? 0 : amountOfOwnedGames.hashCode());
		result = prime * result + ((amountOfPlayedGames == null) ? 0 : amountOfPlayedGames.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((rankingPosition == null) ? 0 : rankingPosition.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStatisticDTO other = (UserStatisticDTO) obj;
		if (amountOfCancelledGames == null) {
			if (other.amountOfCancelledGames != null)
				return false;
		} else if (!amountOfCancelledGames.equals(other.amountOfCancelledGames))
			return false;
		if (amountOfOwnedGames == null) {
			if (other.amountOfOwnedGames != null)
				return false;
		} else if (!amountOfOwnedGames.equals(other.amountOfOwnedGames))
			return false;
		if (amountOfPlayedGames == null) {
			if (other.amountOfPlayedGames != null)
				return false;
		} else if (!amountOfPlayedGames.equals(other.amountOfPlayedGames))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level != other.level)
			return false;
		if (rankingPosition == null) {
			if (other.rankingPosition != null)
				return false;
		} else if (!rankingPosition.equals(other.rankingPosition))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
