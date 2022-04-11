package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Panier;
import com.project.repository.PanierRepository;
import com.project.service.PanierService;

@Service
public class PanierServiceImpl implements PanierService {
	
	@Autowired
	PanierRepository panierRepository;

	@Override
	public Panier findById(int id) {
		return panierRepository.findById(id);
	}

	@Override
	public void save(Panier panier) {
		panierRepository.save(panier);
		
	}

	@Override
	public void delete(Panier panier) {
		panierRepository.delete(panier);
		
	}

	@Override
	public void update(Panier panier) {
		panierRepository.save(panier);
		
	}

	
}
