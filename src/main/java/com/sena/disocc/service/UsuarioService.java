package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.repository.RolRepository;
import com.sena.disocc.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usurepo;

	@Autowired
	RolRepository roleRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<Usuario> listAllUsuarios() {
		return usurepo.findAll();
	}

	public void saveUsuario(Usuario usu) {
		usurepo.save(usu);
	}

	public Usuario findById(Integer id) {
		return usurepo.findById(id).get();
	}

	public void deleteUsuario(Integer id) {
		usurepo.deleteById(id);
	}

	public Usuario findByEmail(String email) {
		return usurepo.findByEmail(email);
	}

	public void registerDefaultUser(Usuario usuario) {	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPassWord = encoder.encode(usuario.getContrasena());
		usuario.setContrasena(encoderPassWord);
		
		
		Rol roleUser = roleRepo.findByname("User");
		usuario.addRole(roleUser);

		usurepo.save(usuario);
	}

}
