package com.m2i.Validator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity @Table(name="characters")
@Getter @Setter  @AllArgsConstructor @ToString
public class Characters {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int level;
	
	private int size;
	
	private int age;
	
	private String email;

	public Characters(String name, int level, int size, int age, String email) {
		super();
		this.name = name;
		this.level = level;
		this.size = size;
		this.age = age;
		this.email = email;
	}
	public Characters() {
		super();
	}
	
	
}
