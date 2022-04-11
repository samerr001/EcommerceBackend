package com.project.service;

import com.project.entities.Role;

public interface RoleService {
	Role findByNom(String role);
	Role findById(int id);
	void save(Role role);
	void delete(Role role);
	void update(Role role);

}
