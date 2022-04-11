package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Produit;
import com.project.entities.User;
import com.project.service.PanierService;
import com.project.service.ProduitService;
import com.project.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/produitRestOperations")
public class ProduitRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	PanierService panierService;
	
	@GetMapping("list")
	public List<Produit> findAll(){
		return produitService.findAll();
	}
	
	
	@GetMapping("find/{id}")
	public Produit findById(@PathVariable("id") int id) {
		return produitService.findById(id);	
	}
	
	@PostMapping("add")
	public void create(@RequestBody Produit a) {
		produitService.save(a);
	}
	
	@PutMapping("update")
	public void update(@RequestBody Produit a) {
		produitService.save(a);
	}
	@DeleteMapping(value = "delete/{id}")
	public void delete(@PathVariable("id") int id) {
		produitService.delete(produitService.findById(id));
	}
	
	public void AjouterAuPanier(@RequestBody Produit pdt ) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByNom(userDetails.getUsername());
		Set<Produit> h = user.getPanier().getProduit();
		h.add(pdt);
		user.getPanier().setProduit(h);
		userService.save(user);
	}
	public void SupprimerDePanier(@RequestBody Produit pdt ) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByNom(userDetails.getUsername());
		Set<Produit> h = user.getPanier().getProduit();
		h.remove(pdt);
		user.getPanier().setProduit(h);
		userService.save(user);
	}


}
