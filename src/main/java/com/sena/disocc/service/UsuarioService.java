package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usurepo;
	
	public List<Usuario> listAllUsuarios(){
		return usurepo.findAll();
	}
	
	public void saveUsuario (Usuario usu) {
		 usurepo.save(usu);	
	}
	
	public Usuario findById(Integer id) {
		return usurepo.findById(id).get();
	}
	
	public void deleteUsuario(Integer id) {
		usurepo.deleteById(id);
	}
}
