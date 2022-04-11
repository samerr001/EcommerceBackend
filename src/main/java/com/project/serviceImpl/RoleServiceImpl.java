package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Role;
import com.project.repository.RoleRepository;
import com.project.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role findByNom(String role) {
		return roleRepository.findByRole(role);
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}
	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
		
	}

	@Override
	public void update(Role role) {
		roleRepository.save(role);
		
	}

}
