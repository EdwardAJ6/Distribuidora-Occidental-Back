package com.sena.disocc.service;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Proveedor;
import com.sena.disocc.repository.ProveedorRepository;


@Service
@Transactional
public class ProveedorService 
{
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> listAllProveedor()
	{
		return proveedorRepository.findAll();
	}
	
	public void saveProveedor(Proveedor proveedor)
	{
		proveedorRepository.save(proveedor);
	}
	
	public Proveedor findById(Integer id)
	{
		return proveedorRepository.findById(id).get();
	}
	
	public void deleteProveedor(Integer id)
	{
		proveedorRepository.deleteById(id);
	}
	
}
