package com.MultiBibliothequeSpringApi.dto;

import java.util.List;


public class IllustrateurDTO {

	private String name;
	
	private List<String> livres;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getLivres() {
		return livres;
	}

	public void setLivres(List<String> livres) {
		this.livres = livres;
	}
	
	
}
