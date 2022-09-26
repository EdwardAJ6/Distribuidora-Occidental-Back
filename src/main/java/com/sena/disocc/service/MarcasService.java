package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Marcas;
import com.sena.disocc.repository.MarcasRepository;

@Service
@Transactional
public class MarcasService {
	
	@Autowired
    private MarcasRepository marcasRepository;
	
	public List<Marcas> listAllMarcas()
	{
		return marcasRepository.findAll();
	}
	
	public void saveMarcas(Marcas marcas)
	{
		marcasRepository.save(marcas);
	}
	
	public Marcas findById(Integer id)
	{
		return marcasRepository.findById(id).get();
	}
	
	public void deleteMarcas(Integer id)
	{
		marcasRepository.deleteById(id);
	}
	
	public MarcasService() {
		// TODO Auto-generated constructor stub
	}

}
