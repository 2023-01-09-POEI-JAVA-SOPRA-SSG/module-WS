package com.m2i.JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.JPA.entity.Eleve;
import com.m2i.JPA.repository.EleveRepository;

@Service
public class EleveService {

	@Autowired
	EleveRepository repo;
	
	
	public Eleve getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Eleve> getAll(){
		return repo.findAll();
	}
	
	public void delete(int id) {
		Eleve e = repo.findById(id).orElse(null);
		if (e != null ) repo.delete( e );
	}
	
	public void create(Eleve e) {
		repo.save(e);
	}
	
	public void update(int id, Eleve e) {
		Eleve eleveInDB = repo.findById(id).orElse(null);
		if (e != null ) {
			eleveInDB.setAge( e.getAge());
			eleveInDB.setClasse( e.getClasse());
			eleveInDB.setFirstName( e.getFirstName());
			eleveInDB.setLastName( e.getLastName());
			repo.save(eleveInDB);
		}
	}

	
	
}
