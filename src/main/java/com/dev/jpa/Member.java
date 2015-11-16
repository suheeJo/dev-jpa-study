package com.dev.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name="MEMBER", uniqueConstraints={@UniqueConstraint(name="unique_member_2", columnNames={"name"})})
public class Member {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_member")
	 @SequenceGenerator(name="seq_member", sequenceName="seq_member", initialValue=1, allocationSize=5)
	 private Long id;
	 
	 @Column(name="name", nullable=false, length=100)
	 private String userName;
	 
	 @Lob
	 private byte[] bytes;
	 
	 private Integer age;
	 
}
