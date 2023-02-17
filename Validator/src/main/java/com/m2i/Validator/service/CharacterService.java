package com.m2i.Validator.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.m2i.Validator.entity.Characters;

public class CharacterService {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	
	public Characters getOne(int id) {
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			return em.find(Characters.class, id);
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	
	public List<Characters> getAll(){
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			return em.createQuery("From Characters", Characters.class).getResultList();
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	
	public void create(Characters c) {
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			em.persist(c);
			
			trans.commit();
			
			
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	
	public void update(int id, Characters c) {
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Characters characterInDB = em.find(Characters.class, id);
			
			characterInDB.setAge( c.getAge() );
			characterInDB.setEmail( c.getEmail() );
			characterInDB.setLevel( c.getLevel() );
			characterInDB.setName( c.getName() );
			characterInDB.setSize( c.getSize() );
			
			em.persist(characterInDB);
			
			trans.commit();
			
			
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	
	public void delete(int id) {
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			em.remove( em.find(Characters.class, id)  );
			
			trans.commit();
						
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	
}
