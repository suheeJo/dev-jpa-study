package com.dev.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Team {

	@Id
	@Column(name = "TEAM_ID")
	private String id;

	private String name;

	@OneToMany(mappedBy = "team")
	@JoinColumn(name="Team_ID")
	private List<Member> memberList;

	public void addMember(Member member) {
		if (this.memberList == null)
			this.memberList = new ArrayList<Member>();

		this.memberList.add(member);
		if (member.getTeam() != this)
			member.setTeam(this);
	}
}
