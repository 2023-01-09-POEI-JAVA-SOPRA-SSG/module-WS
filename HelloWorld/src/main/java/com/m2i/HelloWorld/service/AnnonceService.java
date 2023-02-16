package com.m2i.HelloWorld.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.m2i.HelloWorld.entity.Annonce;

public class AnnonceService {

	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	public final String CONF_NAME = "my-jpa-conf";
	
	
	
	public Annonce getOne(int id) {
		
		try {
			emf = Persistence.createEntityManagerFactory(CONF_NAME);
			em = emf.createEntityManager();

			return em.find(Annonce.class, id);
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}

	public List<Annonce> getAll() {
		try {
			emf = Persistence.createEntityManagerFactory(CONF_NAME);
			em = emf.createEntityManager();

			return em.createQuery("From Annonce",Annonce.class).getResultList();
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	
	}
	
	public void create(Annonce a) {
		try {
			emf = Persistence.createEntityManagerFactory(CONF_NAME);
			em = emf.createEntityManager();

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			em.persist(a);
			
			trans.commit();
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
		
	}
	
	public void update(int id,Annonce a) {
		try {
			emf = Persistence.createEntityManagerFactory(CONF_NAME);
			em = emf.createEntityManager();

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Annonce annonceInDB = em.find(Annonce.class, id);
			annonceInDB.setDate( a.getDate() );
			annonceInDB.setDescription( a.getDescription() );
			annonceInDB.setPrice( a.getPrice() );
			annonceInDB.setTitre( a.getTitre() );
			em.persist(annonceInDB);
			
			trans.commit();
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	
	public void delete(int id) {
		try {
			emf = Persistence.createEntityManagerFactory(CONF_NAME);
			em = emf.createEntityManager();

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Annonce annonceInDB = em.find(Annonce.class, id);

			em.remove(annonceInDB);
			
			trans.commit();
			
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
		}
	}
	

}
