package com.MultiBibliothequeSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MultiBibliothequeSpringApi.model.Illustrateur;




@Repository
public class IllustrateurRepository {

	@PersistenceContext
	EntityManager em;
	


	public Illustrateur findByName(String name) {
		return em.find(Illustrateur.class, name);
	}
	
	
	
	@Transactional
	public Illustrateur save(Illustrateur illustrateur) {
		   
		if(em.find(Illustrateur.class,illustrateur.getName()) == null ) {
			
			em.persist(illustrateur);
		} else {
			
			em.merge(illustrateur);
		}

		return illustrateur;
	}
	
	@Transactional
	public void deleteByName(String name) {
		if (existsByName(name)) {
			Illustrateur illustrateur = findByName(name);
			em.remove(illustrateur);
		}
	}
	
	public boolean existsByName(String name) {
		return em.find(Illustrateur.class, name) != null;
	}
	
	public List<Illustrateur> findAll () {
		return em.createQuery("SELECT i FROM Illustrateur i",Illustrateur.class).getResultList();
	}
}
