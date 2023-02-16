package com.m2i.HelloWorld.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.HelloWorld.entity.Annonce;
import com.m2i.HelloWorld.service.AnnonceService;

/*
 
GET http://localhost:8080/annonce?id={id}
GET http://localhost:8080/annonce

POST http://localhost:8080/annonce + bodu annonce

PUT http://localhost:8080/annonce/{id} + body annonce

DELETE http://localhost:8080/annonce/{id}

 */

/*
 @RequestMapping(value="/rawdata/", method = RequestMethod.PUT)
public ResponseEntity<?> create(@RequestBody String data) {
    if(everything_fine) {
        return new ResponseEntity<>(RestModel, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
 */



@RestController
@RequestMapping("/annonce")
public class AnnonceController {

	private AnnonceService service = new AnnonceService();
	
	@GetMapping("/{id}")
	public ResponseEntity<Annonce> getAnnonce( @PathVariable("id") int id ) {
		Annonce a = service.getOne(id);
		if (a == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Annonce>(service.getOne(id), HttpStatus.OK);
		}
	}
		
	@GetMapping
	public List<Annonce> getAllAnnonces(){
			return service.getAll();			
	}
	
	@PostMapping
	public ResponseEntity<String> createAnnonce(@RequestBody Annonce a) {
		try {
			service.create(a);
			return new ResponseEntity<String>("Annonce crée avec succes", HttpStatus.CREATED);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Annonce non crée", HttpStatus.NOT_ACCEPTABLE);			
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateAnnonce( @PathVariable("id") int id, @RequestBody Annonce a ) {
		try {
			service.update(id, a);
			return new ResponseEntity<String>("Annonce modifié avec succes", HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Annonce non modifié", HttpStatus.NOT_ACCEPTABLE);			
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnnonce(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<String>("Annonce supprimé avec succes", HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Annonce non supprimé", HttpStatus.NOT_ACCEPTABLE);			
		}
	}

}
