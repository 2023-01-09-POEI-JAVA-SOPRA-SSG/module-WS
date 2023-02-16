package com.m2i.HelloWorld.entity;

public class Player {
	
	private String name;
	
	private int elo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public Player(String name, int elo) {
		super();
		this.name = name;
		this.elo = elo;
	}

	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", elo=" + elo + "]";
	}
	
	
	
}
