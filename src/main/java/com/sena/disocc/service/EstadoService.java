package com.sena.disocc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.disocc.modelo.Estado;
import com.sena.disocc.repository.EstadoRepository;

@Service
@Transactional
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepo;
	
	public List<Estado> listAllEstado(){
		return estadoRepo.findAll();
	}
	
	public void saveEstado(Estado estado) {
		estadoRepo.save(estado);
	}
	
	public Estado findById (Integer id) {
		return estadoRepo.findById(id).get();
	}
	
	public void deleteEstado (Integer id) {
		estadoRepo.deleteById(id);
	}
}
