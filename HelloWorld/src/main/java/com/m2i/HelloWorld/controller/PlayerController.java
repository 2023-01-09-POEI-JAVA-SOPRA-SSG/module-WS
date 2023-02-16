package com.m2i.HelloWorld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.HelloWorld.entity.Player;

@RestController
@RequestMapping("/player")
public class PlayerController {

	
	List<Player> players = new ArrayList<>();
	
	@GetMapping
	public List<Player> getAll(){
		return players;
	}
	
	@GetMapping("/{id}")
	public Player getOne(@PathVariable int id) {
		return players.get(id);
	}
	
	@PostMapping
	public void addPlayer( @RequestBody Player p) {
		players.add(p);
	}
	
	@PutMapping
	public void updatePlayer ( @RequestBody Player p, @RequestParam("id") int id) {
		Player playerInList = players.get(id);
		
		playerInList.setElo( p.getElo() );
		playerInList.setName(null);
	}
	
	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id) {
		players.remove(id);
	}
	
	
	
	
}
