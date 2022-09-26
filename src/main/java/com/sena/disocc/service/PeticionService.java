package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Peticion;
import com.sena.disocc.repository.PeticionRepository;

@Service
@Transactional
public class PeticionService {

	@Autowired
	PeticionRepository petiRepo;
	
	public List<Peticion> listAllPeticiones(){
		return petiRepo.findAll();
	}
	
	public void savePeticiones(Peticion peti) {
		petiRepo.save(peti);
	}
	
	public Peticion findById(Integer id) {
		return petiRepo.findById(id).get();
	}
	
	public void eliminar(Integer id) {
		 petiRepo.deleteById(id);
	}
}
