package com.MultiBibliothequeSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MultiBibliothequeSpringApi.model.Editeur;




@Repository
public class EditeurRepository {

	@PersistenceContext
	EntityManager em;
	


	public Editeur findByName(String name) {
		return em.find(Editeur.class, name);
	}
	
	@Transactional
	public Editeur save(Editeur editeur) {
		
		if(em.find(Editeur.class,editeur.getName()) == null ) {
			
			em.persist(editeur);
		} else {
			
			em.merge(editeur);
		}

		return editeur;
	}
	
	@Transactional
	public void deleteByName(String name) {
		if (existsByName(name)) {
			Editeur editeur = findByName(name);
			em.remove(editeur);
		}
	}
	
	public boolean existsByName(String name) {
		return em.find(Editeur.class, name) != null;
	}
	
	public List<Editeur> findAll () {
		return em.createQuery("FROM Editeur",Editeur.class).getResultList();
	}
}
