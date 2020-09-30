package com.capgemini.spring.zadanie.domain.dto;

import java.util.List;

public class UserInformationDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private List<BoardGameDTO> ownedGames;

	public UserInformationDTO() {
	}
	
	public UserInformationDTO(Long id, String firstName, String lastName, String email, String password,
			String lifeMotto, List<BoardGameDTO> ownedGames) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifeMotto = lifeMotto;
		this.ownedGames = ownedGames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public List<BoardGameDTO> getOwnedGames() {
		return ownedGames;
	}

	public void setOwnedGames(List<BoardGameDTO> ownedGames) {
		this.ownedGames = ownedGames;
	}

	public void addGame(BoardGameDTO game) {
		ownedGames.add(game);
	}

	public void removeGame(BoardGameDTO game) {
		ownedGames.remove(game);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lifeMotto == null) ? 0 : lifeMotto.hashCode());
		result = prime * result + ((ownedGames == null) ? 0 : ownedGames.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UserInformationDTO other = (UserInformationDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lifeMotto == null) {
			if (other.lifeMotto != null)
				return false;
		} else if (!lifeMotto.equals(other.lifeMotto))
			return false;
		if (ownedGames == null) {
			if (other.ownedGames != null)
				return false;
		} else if (!ownedGames.equals(other.ownedGames))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}
