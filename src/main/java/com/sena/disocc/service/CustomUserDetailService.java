package com.sena.disocc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.repository.UsuarioRepository;

@Service
public class CustomUserDetailService  implements UserDetailsService{

	@Autowired
	private UsuarioService usuaService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usu = usuaService.findByEmail(email);
		if (usu==null) {
			throw new UsernameNotFoundException("HOLA Usuario no encontrado");			
		}
		return new CustomUserDetail(usu);
	}

}
