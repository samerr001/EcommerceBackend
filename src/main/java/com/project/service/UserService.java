package com.project.service;


import java.util.List;

import com.project.entities.User;

public interface UserService {
	User findByNom(String nom);
	User findById(int id);
	List<User> findAll();
	void save(User user);
	void delete(User user);
	void update(User user);

}
