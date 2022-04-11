package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Panier;

public interface PanierRepository extends JpaRepository<Panier,Integer> {
	Panier findById(int id);

	

}
