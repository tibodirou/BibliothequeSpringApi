package com.MultiBibliothequeSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MultiBibliothequeSpringApi.model.Livre;



@Repository
public class LivreRepository {

	@PersistenceContext
	EntityManager em;
	

	public Livre findById(Long id) {
		return em.find(Livre.class, id);
	}
	
	
	
	@Transactional
	public Livre save(Livre livre) {
		
		em.persist(livre);

		return livre;
	}
	
	@Transactional
	public void deleteById(Long id) {
		if (existsById(id)) {
			Livre livre = findById(id);
			em.remove(livre);
		}
	}
	
	public boolean existsById(Long id) {
		return em.find(Livre.class, id) != null;
	}
	
	public boolean existsByTitle(String title) {
		return em.find(Livre.class, title) != null;
	}
	
	public List<Livre> findAll () {
	    return em.createQuery("SELECT l FROM Livre l",Livre.class).getResultList();
	}
	
	
	
}
