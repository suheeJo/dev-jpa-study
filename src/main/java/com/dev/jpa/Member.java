package com.dev.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MEMBER")
public class Member {
	
	 @Id
	 private String id;
	 
	 @Column(name="name")
	 private String userName;
	 
	 private Integer age;
	 
}
