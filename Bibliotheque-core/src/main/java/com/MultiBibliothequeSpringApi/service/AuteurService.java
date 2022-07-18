package com.MultiBibliothequeSpringApi.service;

import java.util.List;

import com.MultiBibliothequeSpringApi.model.Auteur;




public interface AuteurService {

	public Auteur save(Auteur auteur);
	
	public Auteur update(Auteur auteur);
	
	public List<Auteur> findAll();
	
	public Auteur findOne(String name);
	
	public void delete(Long id);
	
}
