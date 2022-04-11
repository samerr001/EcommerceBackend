package com.project.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.entities.Role;
import com.project.entities.User;
import com.project.service.UserService;

@Service
@Transactional
public class JwtInMemoryUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;
/*
  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
  }
  */

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 /* 
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();*/
	  
	  
	  User user = userService.findByNom(username);
      if (user == null) {
              return null;
      }
      
      String[] roles = new String[user.getRoles().size()];
       int i = 0;
       for (Role role : user.getRoles()) {
      	  roles[i] = role.getRole();
      	  i++;
      	}
    
      List<GrantedAuthority> auth = AuthorityUtils
    //                                .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
      .createAuthorityList(roles);
      	
      String password = user.getMotdepasse();
      //return new org.springframework.security.core.userdetails.User(username, password,auth);
      return new JwtUserDetails(1L,user.getNom(),
    	        user.getMotdepasse(), auth);
  }

}