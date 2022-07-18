package com.MultiBibliothequeSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MultiBibliothequeSpringApi.model.Auteur;



@Repository
public class AuteurRepository {

	@PersistenceContext
	EntityManager em;
	

	public Auteur findByName(String name) {
		return em.find(Auteur.class, name);
	}
	
	@Transactional
	public Auteur save(Auteur auteur) {
		
		if(em.find(Auteur.class,auteur.getName()) == null ) {
			
			em.persist(auteur);
		} else {
			
			em.merge(auteur);
		}
		
		return auteur;
	}
	
	@Transactional
	public void deleteByName(String name) {
		if (existsByName(name)) {
			Auteur auteur = findByName(name);
			em.remove(auteur);
		}
	}
	
	public boolean existsByName(String name) {
		return em.find(Auteur.class, name) != null;
	}
	
	public List<Auteur> findAll () {
		return em.createQuery("FROM Auteur",Auteur.class).getResultList();
	}
}
