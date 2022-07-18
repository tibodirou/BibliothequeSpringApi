package com.MultiBibliothequeSpringApi.service;

import java.util.List;
import java.util.Optional;

import com.MultiBibliothequeSpringApi.model.Livre;



public interface LivreService {

	
	public Livre save(Livre livre);
	
	public Livre update(Livre livre);
	
	public List<Livre> findAll();
	
	public Optional<Livre> findOne(Long id);
	
	public boolean exist(String title);
	
	public boolean exist(Long id);
	
	public void delete(Long id);
	
	
}
