package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByNom(String nom);
	List<User> findAll();
	User findById(int id);

}
