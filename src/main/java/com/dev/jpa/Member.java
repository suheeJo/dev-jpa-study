package com.dev.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "MEMBER", uniqueConstraints = { @UniqueConstraint(name = "unique_member_2", columnNames = { "name" }) })
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_member")
	@SequenceGenerator(name = "seq_member", sequenceName = "seq_member", initialValue = 1, allocationSize = 5)
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	private String userName;

	@Lob
	private byte[] bytes;

	private Integer age;
	
	@ManyToMany
	@JoinTable(name="MEMBER_PRODUCT", joinColumns=@JoinColumn(name="id"),
	inverseJoinColumns=@JoinColumn(name="PRODUCT_ID"))
	private List<Product> products = new ArrayList<Product>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID3")
	private Team team;

	public void setTeam(Team team) {
		this.team = team;

		if (team.getMemberList() == null)
			team.setMemberList(new ArrayList<Member>());

		if (!team.getMemberList().contains(this))
			team.getMemberList().add(this);
	}

}
