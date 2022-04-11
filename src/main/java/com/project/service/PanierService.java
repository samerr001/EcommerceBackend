package com.project.service;

import com.project.entities.Panier;

public interface PanierService {
	Panier findById(int id);
	void save(Panier panier);
	void delete(Panier panier);
	void update(Panier panier);

}
