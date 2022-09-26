package com.sena.disocc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	private RolRepository rolrepo;
	
	public List<Rol> listAllRol(){
		return rolrepo.findAll();
	}
	
	public void saveRol(Rol rol) {
		rolrepo.save(rol);
	}
	
	public Rol findById(Integer id) {
		return rolrepo.findById(id).get();
	}
	
	public void deleteRol(Integer id) {
		rolrepo.deleteById(id);
	}
}
