package com.m2i.JPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.JPA.entity.Eleve;
import com.m2i.JPA.service.EleveService;

@RestController
@RequestMapping("/eleve")
public class EleveController {

	@Autowired
	EleveService eService;
	
	
	@GetMapping("/{id}")
	public Eleve getEleveById(@PathVariable("id") int id) {
		return eService.getById(id);
	}
	
	@GetMapping
	public List<Eleve> getAll(){
		return eService.getAll();
	}
	
	@PostMapping
	public void postEleve(@RequestBody Eleve e) {
		eService.create(e);
	}
	
	@PutMapping("/{id}")
	public void putEleve(@PathVariable("id") int id,@RequestBody Eleve e) {
		eService.update(id, e);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEleve(@PathVariable("id") int id) {
		eService.delete(id);
	}
	
}
