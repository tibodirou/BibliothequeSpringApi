package com.MultiBibliothequeSpringApi.service;

import java.util.List;

import com.MultiBibliothequeSpringApi.model.Editeur;



public interface EditeurService {

	public Editeur save(Editeur editeur);
	
	public Editeur update(Editeur editeur);
	
	public List<Editeur> findAll();
	
	public Editeur findOne(String name);
	
	public void delete(Long id);
}
