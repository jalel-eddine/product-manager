
package com.riahi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jalel Eddine
 *
 * 25 nov. 2018
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit ;
	
	private String designation ;
		
	private double prix;

	
	@ManyToOne                          
	@JoinColumn(name="idCategori")      
	private Categorie categorie;


	public Produit(String designation) {
		super();
		this.designation = designation;
	}
	
	
	
}
