package com.riahi.metier;

import java.util.List;

import com.riahi.entities.Categorie;
import com.riahi.entities.Produit;

/**
 * @author Jalel Eddine
 *
 * 25 nov. 2018
 */
public interface ProductMangerService {

	public List<Categorie> listCategorie();
	public Categorie getCategorie(Long idCat);
	public Categorie getCatByDes(String designation);
	public Categorie enregistrerCategorie(Categorie c );
	public void supprimerCategorie(Long idCat);
	
	public List<Produit> listProduit();
	public Produit getProduit(Long idProd);
	public Produit getProdByDes(String designation);
	public Produit enregistrerProduit(Produit p , Categorie c );
	public void supprimerProduit(Long idproduit);
	
}
