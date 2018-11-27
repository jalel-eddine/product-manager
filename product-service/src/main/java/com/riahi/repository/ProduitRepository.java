package com.riahi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.riahi.entities.Produit;

/**
 * @author Jalel Eddine
 *
 * 25 nov. 2018
 */

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	public Produit findByDesignation(String designation) ;
}
