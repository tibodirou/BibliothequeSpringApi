package com.MultiBibliothequeSpringApi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "illustrateur")
public class Illustrateur {

	
	
	public Illustrateur(String name) {
		this.name = name;
	}
	
	

	public Illustrateur() {
		super();
	}



	@Id
	@Column(name = "name", nullable = false)
	private String name;
	
	
	@OneToMany(mappedBy = "illustrateur", cascade=CascadeType.ALL)
	private List<Livre> livres;


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
