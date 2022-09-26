package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Inventarios;
import com.sena.disocc.repository.InventarioRepository;

@Service
@Transactional
public class InventarioService {
	
	@Autowired
    private InventarioRepository inventarioRepository;
	
	public List<Inventarios> listAllInventarios()
	{
		return inventarioRepository.findAll();
	}
	
	public void saveInventarios(Inventarios inventarios)
	{
		inventarioRepository.save(inventarios);
	}
	
	public Inventarios findById(Integer id)
	{
		return inventarioRepository.findById(id).get();
	}
	
	public void deleteInventarios(Integer id)
	{
		inventarioRepository.deleteById(id);
	}
	public InventarioService() {
		// TODO Auto-generated constructor stub
	}

}
