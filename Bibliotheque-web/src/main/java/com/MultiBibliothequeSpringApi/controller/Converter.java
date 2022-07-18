package com.MultiBibliothequeSpringApi.controller;

import java.util.stream.Collectors;

import com.MultiBibliothequeSpringApi.dto.LivreDTO;
import com.MultiBibliothequeSpringApi.model.Collection;
import com.MultiBibliothequeSpringApi.model.Livre;


public class Converter {

	public static LivreDTO entityToDto(Livre livre) {
		LivreDTO livreDTO = new LivreDTO();
		livreDTO.setId(livre.getId());
		livreDTO.setTitre(livre.getTitre());
		livreDTO.setAuteur(livre.getAuteur().getName());
		livreDTO.setIllustrateur(livre.getIllustrateur().getName());
		livreDTO.setEditeur(livre.getEditeur().getName());
		livreDTO.setCollections(livre.getCollections().stream().map(Collection::getName).collect(Collectors.toList()));
		return livreDTO;
	}
	
}
