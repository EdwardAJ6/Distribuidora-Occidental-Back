package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Productos;
import com.sena.disocc.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
    private ProductoRepository productoRepository;
	
	public List<Productos> listAllProductos()
	{
		return productoRepository.findAll();
	}
	
	public void saveProductos(Productos productos)
	{
		productoRepository.save(productos);
	}
	
	public Productos findById(Integer id)
	{
		return productoRepository.findById(id).get();
	}
	
	public void deleteProductos(Integer id)
	{
		productoRepository.deleteById(id);
	}

}
