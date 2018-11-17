package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Personne;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	PersonneRepository personneRepository;

	@Override
	public UserDetailsImpl loadUserByUsername(String mail) throws UsernameNotFoundException {
		Personne personne = personneRepository.findByMail(mail);
		if (null == personne) {
			throw new UsernameNotFoundException("No user with email " + mail);
		} else {
			return new UserDetailsImpl(personne);
		}
	}

}
