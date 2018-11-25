package com.riahi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riahi.entities.Produit;

/**
 * @author Jalel Eddine
 *
 * 25 nov. 2018
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	public Produit findByDesignation(String designation) ;
}
