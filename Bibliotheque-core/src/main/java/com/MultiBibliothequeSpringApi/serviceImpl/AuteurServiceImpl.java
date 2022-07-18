package com.MultiBibliothequeSpringApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultiBibliothequeSpringApi.model.Auteur;
import com.MultiBibliothequeSpringApi.repository.AuteurRepository;



@Service
public class AuteurServiceImpl {

	@Autowired
	private AuteurRepository auteurRepository;
	
	public Auteur save(Auteur auteur) {
		return auteurRepository.save(auteur);
	}
	
	public Auteur update(Auteur auteur) {
		return auteurRepository.save(auteur);
	}
	
	public List<Auteur> findAll(){
		return auteurRepository.findAll();
	}
	
	public Auteur findOne(String name) {
		return auteurRepository.findByName(name);
	}
	
	public void delete(String name) {
		auteurRepository.deleteByName(name);
	}
}
