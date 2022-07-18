package com.MultiBibliothequeSpringApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultiBibliothequeSpringApi.model.Livre;
import com.MultiBibliothequeSpringApi.repository.LivreRepository;



@Service
public class LivreServiceImpl {

	@Autowired
	private LivreRepository livreRepository;
	
	
	public Livre save(Livre livre) {
		return livreRepository.save(livre);
	}
	
	public Livre update(Livre livre) {
		return livreRepository.save(livre);
	}
	
	public List<Livre> findAll(){
		return livreRepository.findAll();
	}
	
	public Livre findOne(Long id) {
		return livreRepository.findById(id);
	}
	
	public boolean exist(String title) {
		return livreRepository.existsByTitle(title);
	}
	
	public boolean exist(Long id) {
		return livreRepository.existsById(id);
	}
	
	public void delete(Long id) {
		livreRepository.deleteById(id);
	}
}
