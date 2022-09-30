package com.sena.disocc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.modelo.Usuario;



public class CustomUserDetail implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private Usuario usu;
	
	public CustomUserDetail(Usuario usu) {
		this.usu=usu;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Rol> roles = usu.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Rol role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getNomRol()));
        }
        return authorities;
	}

	@Override
	public String getPassword() {
		return usu.getContrasena() ;
	}

	@Override
	public String getUsername() {
		
		return usu.getEmail();
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
	
	public String Fullname() {
		return usu.getPrimerNombre() + " " + usu.getPrimerApellido();
	}
	
	public boolean hasRol(String rolName) {
		return usu.hasRol(rolName);
	}
	
	public int getId() {
		return usu.getIdUsuario();
	}
	

	

}
