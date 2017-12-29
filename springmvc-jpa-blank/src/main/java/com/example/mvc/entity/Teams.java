package com.example.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name="Teams.findById", query="SELECT a FROM Teams a WHERE A.teamId = ?1")
@Table(name="TEAMS")
public class Teams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEAMID")
	@GeneratedValue
	private Integer teamId;
	
	@Column(name="TEAMNAME")
	@NotNull
	private String teamName;
	
	@Column(name="TEAMMEMCOUNT")
	@NotNull
	private int teamMemCount;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamMemCount() {
		return teamMemCount;
	}

	public void setTeamMemCount(int teamMemCount) {
		this.teamMemCount = teamMemCount;
	}

	
	
	
	
	
}
