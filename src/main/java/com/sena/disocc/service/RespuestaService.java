package com.sena.disocc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.disocc.modelo.Respuesta;
import com.sena.disocc.repository.RespuestaRepository;

@Service
@Transactional
public class RespuestaService {
	@Autowired
	RespuestaRepository resRepo;
	
	public List<Respuesta> listaAllRespuestas(){
		return resRepo.findAll();
	}
	
	public void saveRespuestas(Respuesta res) {
		resRepo.save(res);
	}
	public Respuesta findById(Integer id) {
		return resRepo.findById(id).get();
	}
	
	public void deleteRespuestas(Integer id) {
		resRepo.deleteById(id);
	}
}
