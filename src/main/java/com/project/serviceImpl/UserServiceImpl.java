package com.project.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.entities.Panier;
import com.project.entities.Role;
import com.project.entities.User;
import com.project.repository.PanierRepository;
import com.project.repository.UserRepository;
import com.project.service.RoleService;
import com.project.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	PanierRepository panierRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findByNom(String nom) {
		return userRepository.findByNom(nom);
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}
	@Autowired
	private RoleService roleservice;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(User user) {
		user.setMotdepasse(bCryptPasswordEncoder.encode(user.getMotdepasse()));
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleservice.findByNom("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
		Panier panier = new Panier();
		panier.setUser(userRepository.findByNom(user.getNom()));
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	

}
