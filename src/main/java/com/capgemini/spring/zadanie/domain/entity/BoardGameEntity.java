package com.capgemini.spring.zadanie.domain.entity;

public class BoardGameEntity {

	private Long id;
	private String gameName;
	
	public BoardGameEntity() {
	}
	
	public BoardGameEntity(Long id, String gameName) {
		this.id = id;
		this.gameName = gameName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameName == null) ? 0 : gameName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BoardGameEntity other = (BoardGameEntity) obj;
		if (gameName == null) {
			if (other.gameName != null)
				return false;
		} else if (!gameName.equals(other.gameName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
