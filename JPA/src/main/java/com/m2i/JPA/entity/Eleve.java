package com.m2i.JPA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="eleve")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Eleve {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int classe;
	
	private String firstName;
	
	private String lastName;
	
	private int age;

	public Eleve(int classe, String firstName, String lastName, int age) {
		super();
		this.classe = classe;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
}
