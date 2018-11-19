package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Personne;
import com.example.demo.model.Role;

public class UserDetailsImpl implements UserDetails {

	private Personne personne;

	public UserDetailsImpl(Personne user) {
		this.personne = user;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(personne.getType()));
//		// authorities.add(new SimpleGrantedAuthority("administrateur"));
//		System.out.println("AUTORISATION : " + personne.getType());
//		return authorities;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (final Role role : personne.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getTitre()));
			System.out.println("AUTORISATION : " + role.getTitre());
		}
			
		return authorities;
	}

	// adminisitrateur, journaliste, utilisateur

	@Override
	public String getPassword() {
		System.out.println("MDP :" + personne.getMdp());
		return personne.getMdp();
	}

	@Override
	public String getUsername() {
		//System.out.println("NOM :" + personne.getNom());
		//return personne.getNom();
		System.out.println("mail: "+personne.getMail());
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
