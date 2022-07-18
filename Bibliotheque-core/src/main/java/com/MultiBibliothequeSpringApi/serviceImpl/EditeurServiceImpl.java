package com.MultiBibliothequeSpringApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultiBibliothequeSpringApi.model.Editeur;
import com.MultiBibliothequeSpringApi.repository.EditeurRepository;



@Service
public class EditeurServiceImpl {

	@Autowired
	private EditeurRepository editeurRepository;
	
	
	public Editeur save(Editeur editeur) {
		return editeurRepository.save(editeur);
	}
	
	public Editeur update(Editeur editeur) {
		return editeurRepository.save(editeur);
	}
	
	public List<Editeur> findAll(){
		return editeurRepository.findAll();
	}
	
	public Editeur findOne(String name) {
		return editeurRepository.findByName(name);
	}
	
	public void delete(String name) {
		editeurRepository.deleteByName(name);
	}
}
