package com.riahi.web.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.riahi.model.Categorie;
import com.riahi.model.Produit;

/**
 * @author Jalel Eddine
 *
 * 27 nov. 2018
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
    RestTemplate restTemplate ;
    
	@GetMapping("/categories")
	public Collection<Categorie> listcat(){
		ParameterizedTypeReference<Collection<Categorie>> ptr =
				new ParameterizedTypeReference<Collection<Categorie>>() {
				};
				
				Collection<Categorie> categories = this.restTemplate.exchange("http://product-service/prod/categories",
		                HttpMethod.GET, null, ptr).getBody();	
				
		return categories;
	}
	
	@GetMapping("/produits")
	public Collection<Produit> listprod(){
		ParameterizedTypeReference<Collection<Produit>> ptr =
				new ParameterizedTypeReference<Collection<Produit>>() {
				};
				
				Collection<Produit> produits = this.restTemplate.exchange("http://product-service/prod/produits",
		                HttpMethod.GET, null, ptr).getBody();	
				
		return produits;
	}
	
	@GetMapping("/categories/{id}")
	public Categorie cat(@PathVariable Long id){
		
		ParameterizedTypeReference<Categorie> ptr =
				new ParameterizedTypeReference<Categorie>() {
				};
				
				Categorie categorie = this.restTemplate.exchange("http://product-service/prod/categories/"+id,
		                HttpMethod.GET, null, ptr ).getBody();	
				
		return categorie;          
	}
	
	@GetMapping("/produits/{id}")
	public Produit prod(@PathVariable Long id){
		
		ParameterizedTypeReference<Produit> ptr =
				new ParameterizedTypeReference<Produit>() {
				};
				
				Produit produit = this.restTemplate.exchange("http://product-service/prod/produits/"+id,
		                HttpMethod.GET, null, ptr ).getBody();	
				
		return produit;          
	}
	
	
	
}
