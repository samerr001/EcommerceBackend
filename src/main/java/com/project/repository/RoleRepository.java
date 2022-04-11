package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Role;
import com.project.entities.User;

public interface RoleRepository extends JpaRepository<Role,String> {
	Role findByRole(String role);
	List<Role> findAll();
	Role findById(int id);



	

}
