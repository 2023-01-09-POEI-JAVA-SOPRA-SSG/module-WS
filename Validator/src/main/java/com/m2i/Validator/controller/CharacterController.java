package com.m2i.Validator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.Validator.entity.Characters;
import com.m2i.Validator.service.CharacterService;



@RestController
@RequestMapping("/character")
public class CharacterController {
	
	CharacterService cService = new CharacterService();
	
	
	@GetMapping("/{id}")
	public Characters getCharacterById(@PathVariable("id") int id) {
		System.out.println("get by id :" + id);
		
		return cService.getOne(id);
	}
	
	@GetMapping
	public List<Characters> getAllCharacters(){
		System.out.println("get all");

		return cService.getAll();
	}
	
	@PostMapping
	public void postCharacter(@RequestBody Characters c) {
		System.out.println("post :" + c);
		cService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCharacter(@PathVariable int id,@RequestBody Characters c) {
		System.out.println("put :" + id + " :: " + c);
		cService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCharacter(@PathVariable int id) {
		System.out.println("delete :" + id);
		cService.delete(id);
	}
	
	
}
