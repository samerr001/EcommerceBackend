package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Produit;
import com.project.repository.ProduitRepository;
import com.project.service.ProduitService;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public Produit findByNompdt(String nompdt) {
		return produitRepository.findByNompdt(nompdt);
	}

	@Override
	public Produit findById(int id) {
		return produitRepository.findById(id);
	}

	@Override
	public void save(Produit pdt) {
		produitRepository.save(pdt);
		
	}

	@Override
	public void delete(Produit pdt) {
		produitRepository.delete(pdt);
	}

	@Override
	public void update(Produit pdt) {
		produitRepository.save(pdt);
	}

	@Override
	public List<Produit> findAll() {
		return produitRepository.findAll();
		
	}
	
	
	
	

}
