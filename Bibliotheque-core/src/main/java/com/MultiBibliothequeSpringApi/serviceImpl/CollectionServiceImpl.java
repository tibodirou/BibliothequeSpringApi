package com.MultiBibliothequeSpringApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultiBibliothequeSpringApi.model.Collection;
import com.MultiBibliothequeSpringApi.repository.CollectionRepository;



@Service
public class CollectionServiceImpl {

	@Autowired
	private CollectionRepository collectionRepository;
	
	
	public Collection save(Collection collection) {
		return collectionRepository.save(collection);
	}
	
	public Collection update(Collection collection) {
		return collectionRepository.save(collection);
	}
	
	public List<Collection> findAll(){
		return collectionRepository.findAll();
	}
	
	public Collection findOne(String name) {
		return collectionRepository.findByName(name);
	}
	
	public void delete(String name) {
		collectionRepository.deleteByName(name);
	}
}
