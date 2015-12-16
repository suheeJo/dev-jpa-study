package com.dev.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data@Entity
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	private String id;

	private String name;
}
