package com.capgemini.spring.zadanie.domain.dto;

import java.util.Date;

public class PlayabilityDTO {
	
	private Long id;
	private UserInformationDTO user;
	private Date startDate;
	private Date endDate;
	private String comment;
	private boolean isActual;

	public PlayabilityDTO() {
	}
	
	public PlayabilityDTO(Long id, UserInformationDTO user, Date startDate, Date endDate, String comment,
			boolean isActual) {
		this.id = id;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.isActual = isActual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserInformationDTO getUser() {
		return user;
	}

	public void setUser(UserInformationDTO user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isActual() {
		return isActual;
	}

	public void setActual(boolean isActual) {
		this.isActual = isActual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActual ? 1231 : 1237);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		PlayabilityDTO other = (PlayabilityDTO) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActual != other.isActual)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
