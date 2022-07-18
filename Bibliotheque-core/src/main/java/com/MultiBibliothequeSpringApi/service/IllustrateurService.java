package com.MultiBibliothequeSpringApi.service;

import java.util.List;

import com.MultiBibliothequeSpringApi.model.Illustrateur;



public interface IllustrateurService {

	public Illustrateur save(Illustrateur illustrateur);
	
	public Illustrateur update(Illustrateur illustrateur);
	
	public List<Illustrateur> findAll();
	
	public Illustrateur findOne(String name);
	
	public void delete(Long id);
}
