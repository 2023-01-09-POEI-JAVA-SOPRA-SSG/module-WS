package com.m2i.HelloWorld.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.m2i.HelloWorld.entity.Annonce;

public class AnnonceService {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	
	
	
	public List<Annonce> getAll(){
		try {
            emf = Persistence.createEntityManagerFactory("my-jpa-conf");
            em = emf.createEntityManager();
            
            return em.createQuery("From Annonce", Annonce.class).getResultList();

            
		} finally {
            if ( em != null ) em.close();
            if ( emf != null ) emf.close();
		}
	}
	
	public Annonce getOne(int id) {
		try {
            emf = Persistence.createEntityManagerFactory("my-jpa-conf");
            em = emf.createEntityManager();
            return em.find(Annonce.class, 4); 

		} finally {
            if ( em != null ) em.close();
            if ( emf != null ) emf.close();
		}
	}
	
	public void create(Annonce a) {
		try {
            emf = Persistence.createEntityManagerFactory("my-jpa-conf");
            em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
		    trans.begin();
		  
		    em.persist(a);
		  
		    trans.commit();
            
		} finally {
            if ( em != null ) em.close();
            if ( emf != null ) emf.close();
		}
	}
	
	public void update(int id, Annonce a) {
		try {
            emf = Persistence.createEntityManagerFactory("my-jpa-conf");
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
            if ( em != null ) em.close();
            if ( emf != null ) emf.close();
		}
	}
	
	public void delete(int id) {
		try {
            emf = Persistence.createEntityManagerFactory("my-jpa-conf");
            em = emf.createEntityManager();

            EntityTransaction trans = em.getTransaction();
            trans.begin();

            Annonce annonceInDB = em.find(Annonce.class, id);
            em.remove(annonceInDB);
          
            trans.commit();
            
		} finally {
            if ( em != null ) em.close();
            if ( emf != null ) emf.close();
		}
	}
	
	

}
