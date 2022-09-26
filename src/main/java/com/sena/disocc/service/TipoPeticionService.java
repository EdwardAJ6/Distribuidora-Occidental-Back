package com.sena.disocc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.disocc.modelo.TipoPeticion;
import com.sena.disocc.repository.TipoPeticionRepository;

@Service
@Transactional
public class TipoPeticionService {

	@Autowired
	TipoPeticionRepository tipoRepo;
	
	public List<TipoPeticion> listAllTipoPeticiones(){
		return tipoRepo.findAll();
	}
	
	public void saveTipoPeticiones(TipoPeticion tipoP) {
		tipoRepo.save(tipoP);
	}
	
	public TipoPeticion findById(Integer id) {
		return tipoRepo.findById(id).get();
	}
	
	public void deleteTipoPeticiones(Integer id) {
		tipoRepo.deleteById(id);
	}
}
