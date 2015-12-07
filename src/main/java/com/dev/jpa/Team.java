package com.dev.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Team {

	@Id
	@Column(name="TEAM_ID")
	private String id;
	
	private String name;
	
	@OneToMany(mappedBy="team")
	private List<Member> memberList;
	
}
