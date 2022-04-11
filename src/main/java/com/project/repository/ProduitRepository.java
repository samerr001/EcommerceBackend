package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Produit;

public interface ProduitRepository  extends JpaRepository<Produit,Integer> { 
	Produit findByNompdt(String nompdt);
	List<Produit> findAll();
	Produit findById(int id);

}
