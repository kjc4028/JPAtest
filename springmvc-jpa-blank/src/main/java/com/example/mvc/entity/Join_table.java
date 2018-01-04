package com.example.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "JOIN_TABLE")
public class Join_table {
	
	@Id
	@Column(name="JOINID")
	@GeneratedValue
	private Integer joinId;
	
	    @Column(name = "PERSON_ID")
	    private Integer id;

	    @Column(name = "PERSON_NAME")
	    @Size(min = 1, max = 30)
	    @NotNull
	    private String name;

	    @Column(name = "AGE")
	    @Min(1)
	    @Max(200)
	    @NotNull
	    private Integer age;
	    
		@Column(name="TEAMID")
		private Integer teamId;
		
		@Column(name="TEAMNAME")
		@NotNull
		private String teamName;
		
		@Column(name="TEAMMEMCOUNT")
		@NotNull
		private int teamMemCount;

		public Integer getJoinId() {
			return joinId;
		}

		public void setJoinId(Integer joinId) {
			this.joinId = joinId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

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
