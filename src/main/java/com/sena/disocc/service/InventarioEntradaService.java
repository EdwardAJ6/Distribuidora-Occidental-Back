package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.InventarioEntradas;
import com.sena.disocc.repository.InventarioEntradaRepository;

@Service
@Transactional
public class InventarioEntradaService {
	
	@Autowired
    private InventarioEntradaRepository inventarioEntradaRepository;
	
	public List<InventarioEntradas> listAllInventarioEntradas()
	{
		return inventarioEntradaRepository.findAll();
	}
	
	public void saveInventarioEntradas(InventarioEntradas inventarioEntradas)
	{
		inventarioEntradaRepository.save(inventarioEntradas);
	}
	
	public InventarioEntradas findById(Integer id)
	{
		return inventarioEntradaRepository.findById(id).get();
	}
	
	public void deleteInventarioEntradas(Integer id)
	{
		inventarioEntradaRepository.deleteById(id);
	}
	
	public InventarioEntradaService() {
		// TODO Auto-generated constructor stub
	}

}
