package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.InventarioSalidas;
import com.sena.disocc.repository.InventarioSalidaRepository;

@Service
@Transactional
public class InventarioSalidaService {
	
	@Autowired
    private InventarioSalidaRepository inventarioSalidaRepository;
	
	public List<InventarioSalidas> listAllInventarioSalidas()
	{
		return inventarioSalidaRepository.findAll();
	}
	
	public void saveInventarioSalidas(InventarioSalidas inventarioSalidas)
	{
		inventarioSalidaRepository.save(inventarioSalidas);
	}
	
	public InventarioSalidas findById(Integer id)
	{
		return inventarioSalidaRepository.findById(id).get();
	}
	
	public void deleteInventarioSalidas(Integer id)
	{
		inventarioSalidaRepository.deleteById(id);
	}
	public InventarioSalidaService() {
		// TODO Auto-generated constructor stub
	}

}
