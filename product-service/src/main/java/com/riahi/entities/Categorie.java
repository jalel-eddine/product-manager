package com.riahi.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jalel Eddine
 *
 * 25 nov. 2018
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCategori;
  
	private String nomCategorie;
	
	private String description;
	
	private String nomPhoto;
	
	@OneToMany(mappedBy="categorie" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)       
	private Collection<Produit> Produits  ;

	public Categorie(String nomCategorie) { 
		super();
		this.nomCategorie = nomCategorie;
	}
	
	
}
