package com.MultiBibliothequeSpringApi.service;

import java.util.List;

import com.MultiBibliothequeSpringApi.model.Collection;



public interface CollectionService {

	public Collection save(Collection collection);
	
	public Collection update(Collection collection);
	
	public List<Collection> findAll();
	
	public Collection findOne(String name);
	
	public void delete(Long id);
}
