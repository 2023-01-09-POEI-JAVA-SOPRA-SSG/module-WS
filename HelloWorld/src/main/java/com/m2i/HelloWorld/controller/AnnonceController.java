package com.m2i.HelloWorld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.HelloWorld.Services.AnnonceService;
import com.m2i.HelloWorld.entity.Annonce;

/*
 
GET http://localhost:8080/annonce?id={id}
GET http://localhost:8080/annonce

POST http://localhost:8080/annonce + bodu annonce

PUT http://localhost:8080/annonce/{id} + body annonce

DELETE http://localhost:8080/annonce/{id}

 */


@RestController
@RequestMapping("/annonce")
public class AnnonceController {

	
	private AnnonceService service = new AnnonceService();	
	
	@GetMapping("/{id}")
	public Annonce getAnnonce( @PathVariable("id") int id ) {
		return service.getOne(id);
	}
		
	@GetMapping
	public List<Annonce> getAllAnnonces(){
		return service.getAll();
	}
	
	@PostMapping
	public void createAnnonce(@RequestBody Annonce a) {
		service.create(a);
	}

	@PutMapping("/{id}")
	public void updateAnnonce( @PathVariable("id") int id, @RequestBody Annonce a ) {
		service.update(id, a);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteAnnonce(@PathVariable("id") int id) {
		service.delete(id);
	}
}
