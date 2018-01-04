package com.example.mvc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Teams.findById", query="SELECT a FROM Teams a WHERE a.teamId = ?1"),
	@NamedQuery(name="Teams.countByTeamName", query="SELECT count(*) FROM Teams a WHERE a.teamName = ?1"),
	@NamedQuery(name="Teams.join", query="SELECT t.* FROM teams t inner join t_person p WHERE t.teamId = p.person_id")
})
@Table(name="TEAMS")
public class Teams implements Serializable {


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
	
	/*@OneToOne
	@JoinTable(name = "JOIN_TABLE",
		joinColumns = @JoinColumn(name="TEAMID", referencedColumnName="TEAMID"),
		inverseJoinColumns = @JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID"))
	private List<Person> person2;*/
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="PERSON_ID")
	private List<Person> person;
 
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

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public List<Person> getPerson2() {
		return person2;
	}

	public void setPerson2(List<Person> person2) {
		this.person2 = person2;
	}

	

	
}
