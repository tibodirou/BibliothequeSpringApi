package com.MultiBibliothequeSpringApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultiBibliothequeSpringApi.model.Illustrateur;
import com.MultiBibliothequeSpringApi.repository.IllustrateurRepository;



@Service
public class IllustrateurServiceImpl {

	@Autowired
	private IllustrateurRepository illustrateurRepository;
	
	
	public Illustrateur save(Illustrateur illustrateur) {
		return illustrateurRepository.save(illustrateur);
	}
	
	public Illustrateur update(Illustrateur illustrateur) {
		return illustrateurRepository.save(illustrateur);
	}
	
	public List<Illustrateur> findAll(){
		return illustrateurRepository.findAll();
	}
	
	public Illustrateur findOne(String name) {
		return illustrateurRepository.findByName(name);
	}
	
	public void delete(String name) {
		illustrateurRepository.deleteByName(name);
	}
}
