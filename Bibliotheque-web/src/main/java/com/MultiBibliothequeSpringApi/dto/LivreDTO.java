package com.MultiBibliothequeSpringApi.dto;

import java.util.List;


public class LivreDTO {

	
	private Long id;
	
	private String titre;
	
	private String auteur;
	
	private String illustrateur;
	
	private String editeur;
	
	private List<String> collections;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIllustrateur() {
		return illustrateur;
	}

	public void setIllustrateur(String illustrateur) {
		this.illustrateur = illustrateur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public List<String> getCollections() {
		return collections;
	}

	public void setCollections(List<String> collections) {
		this.collections = collections;
	}
	
	
	
}
