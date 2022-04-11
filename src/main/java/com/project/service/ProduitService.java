package com.project.service;

import java.util.List;

import com.project.entities.Produit;

public interface ProduitService {
	Produit findByNompdt(String nompdt);
	Produit findById(int id);
	List<Produit> findAll();
	void save(Produit pdt);
	void delete(Produit pdt);
	void update(Produit pdt);

}
