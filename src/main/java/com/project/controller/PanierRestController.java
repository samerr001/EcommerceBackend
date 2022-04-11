package com.project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Panier;
import com.project.entities.Produit;
import com.project.entities.User;
import com.project.service.PanierService;
import com.project.service.ProduitService;
import com.project.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/panierRestOperations")
public class PanierRestController {
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PanierService panierService;
	
	@GetMapping("panier")
	public Set<Produit> findAll(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByNom(userDetails.getUsername());
		return user.getPanier().getProduit();
	}
	@PostMapping("add/{id}")
	public void add(@RequestParam int id) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByNom(userDetails.getUsername());
		Panier panier = user.getPanier();
		Set<Produit> setprod=panier.getProduit();
		setprod.add(produitService.findById(id));
		panier.setProduit(setprod);
		panierService.save(panier);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@RequestParam int id) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByNom(userDetails.getUsername());
		Panier panier = user.getPanier();
		Set<Produit> setprod=panier.getProduit();
		setprod.remove(produitService.findById(id));
		panier.setProduit(setprod);
		panierService.save(panier);
	}
	
	

}
