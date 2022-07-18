package com.MultiBibliothequeSpringApi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auteur")
public class Auteur implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "auteur", cascade=CascadeType.ALL)
	private List<Livre> livres;

	
	
	
	
	public Auteur(String name) {
		this.name = name;
	}
	
	public Auteur() {

	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	
	
	
}
