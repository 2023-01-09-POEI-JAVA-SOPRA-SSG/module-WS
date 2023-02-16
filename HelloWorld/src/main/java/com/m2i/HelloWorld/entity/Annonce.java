package com.m2i.HelloWorld.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table(name="annonce")
public class Annonce {

	@Id @GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	private String description;
	private int price;
	private Date date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Annonce(String titre, String description, int price, Date date) {
		super();
		this.titre = titre;
		this.description = description;
		this.price = price;
		this.date = date;
	}
	public Annonce() {
		super();
	}
	
	@Override
	public String toString() {
		return "Annonce [titre=" + titre + ", description=" + description + ", price=" + price + ", date=" + date + "]";
	}
	
	
	
	
	
}