package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.CategoriasProductos;
import com.sena.disocc.repository.CategoriaProductoRepository;

@Service
@Transactional
public class CategoriaProductoService {

	@Autowired
    private CategoriaProductoRepository categoriaProductoRepository;
	
	public List<CategoriasProductos> listAllCategoriasProductos()
	{
		return categoriaProductoRepository.findAll();
	}
	
	public void saveCategoriasProductos(CategoriasProductos categoriasProductos)
	{
		categoriaProductoRepository.save(categoriasProductos);
	}
	
	public CategoriasProductos findById(Integer id)
	{
		return categoriaProductoRepository.findById(id).get();
	}
	
	public void deleteCategoriasProductos(Integer id)
	{
		categoriaProductoRepository.deleteById(id);
	}

}
