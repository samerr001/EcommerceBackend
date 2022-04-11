package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.entities.Role;
import com.project.service.RoleService;
@Component
public class taskRunner implements CommandLineRunner{
	
	 @Autowired
	 private RoleService roleService;
	@Override
	public void run(String... args) throws Exception {
	/*
		Role r = new Role();
		r.setRole("ROLE_VENDOR");
		roleService.save(r);
		*/
		
		
	}

}
