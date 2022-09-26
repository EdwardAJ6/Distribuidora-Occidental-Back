package com.sena.disocc.service;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.DetalleCompra;
import com.sena.disocc.repository.DetalleCompraRepository;


@Service
@Transactional
public class DetalleCompraService 
{
	@Autowired
	private DetalleCompraRepository detalleCompraRepository;
	
	public List<DetalleCompra> listAllDetallesCompra()
	{
		return detalleCompraRepository.findAll();
	}
	
	public void saveDetalleCompra(DetalleCompra detalleCompra)
	{
		detalleCompraRepository.save(detalleCompra);
	}
	
	public DetalleCompra findById(Integer id)
	{
		return detalleCompraRepository.findById(id).get();
	}
	
	public void deleteDetalleCompra(Integer id)
	{
		detalleCompraRepository.deleteById(id);
	}
}
