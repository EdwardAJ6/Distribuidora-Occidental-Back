package com.sena.disocc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.disocc.modelo.Permiso;
import com.sena.disocc.repository.PermisoRepository;

@Service
@Transactional
public class PermisoService {

	@Autowired
	private PermisoRepository permiRepo;
	
	public List<Permiso> listAllPermiso (){
		return permiRepo.findAll();
	}
	
	public void savePermiso (Permiso permiso) {
		permiRepo.save(permiso);
	}
	
	public Permiso findById (Integer id) {
		return permiRepo.findById(id).get();
	}
	
	public void deletePermiso(Integer id) {
		permiRepo.deleteById(id);
	}
}
