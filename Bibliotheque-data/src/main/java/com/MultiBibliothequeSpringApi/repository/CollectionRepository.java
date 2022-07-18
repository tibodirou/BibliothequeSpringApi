package com.MultiBibliothequeSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MultiBibliothequeSpringApi.model.Collection;




@Repository
public class CollectionRepository {

	@PersistenceContext
	EntityManager em;
	

	public Collection findByName(String name) {
		return em.find(Collection.class, name);
	}
	
	@Transactional
	public Collection save(Collection collection) {
		
        
		if(em.find(Collection.class,collection.getName()) == null ) {
			
			em.persist(collection);
		} else {
			
			em.merge(collection);
		}
		return collection;
	}
	
	@Transactional
	public void deleteByName(String name) {
		if (existsByName(name)) {
			Collection collection = findByName(name);
			em.remove(collection);
		}
	}
	
	public boolean existsByName(String name) {
		return em.find(Collection.class, name) != null;
	}
	
	public List<Collection> findAll () {
		return em.createQuery("FROM Collection",Collection.class).getResultList();
	}
}
