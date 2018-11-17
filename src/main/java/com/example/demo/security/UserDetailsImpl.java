package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Personne;

public class UserDetailsImpl implements UserDetails {

	private Personne personne;

	public UserDetailsImpl(Personne user) {
		this.personne = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(personne.getType()));
			System.out.println(personne.getType());
		return authorities;
	}
	
	//adminisitrateur, journaliste, utilisateur

	@Override
	public String getPassword() {
		return personne.getMdp();
	}

	@Override
	public String getUsername() {
		//return personne.getNom();
		return personne.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
