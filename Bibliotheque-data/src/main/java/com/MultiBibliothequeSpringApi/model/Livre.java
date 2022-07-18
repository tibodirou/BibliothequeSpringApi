package com.MultiBibliothequeSpringApi.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livre",schema = "public")
public class Livre {	

	
	
	public Livre() {
		super();
	}

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String titre;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "auteur_name")
	private Auteur auteur;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "illustrateur_name")
	private Illustrateur illustrateur;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "editeur_name")
	private Editeur editeur;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(
			name = "livre_collection",
            joinColumns = @JoinColumn(name = "livre_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_name")		
			)
	private List<Collection> collections;
	
	

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

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Illustrateur getIllustrateur() {
		return illustrateur;
	}

	public void setIllustrateur(Illustrateur illustrateur) {
		this.illustrateur = illustrateur;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
		
}
