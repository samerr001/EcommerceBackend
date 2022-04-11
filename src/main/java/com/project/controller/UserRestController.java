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
@RequestMapping("/userRestOperations")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("listusers")
	public List<User> findAll(){
		return userService.findAll();
	}

}
