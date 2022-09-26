package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.DetalleVenta;
import com.sena.disocc.repository.DetalleVentaRepository;


@Service
@Transactional
public class DetalleVentaService {

	@Autowired
	private DetalleVentaRepository detalleVentaRepo;
	
	public List<DetalleVenta> listAllDetallesVenta(){
		return detalleVentaRepo.findAll();
	}
	
	public void saveDetalleVenta (DetalleVenta detalleVenta) {
		detalleVentaRepo.save(detalleVenta);	
	}
	
	public DetalleVenta findById(Integer id) {
		return detalleVentaRepo.findById(id).get();
	}
	
	public void deleteDetalle(Integer id) {
		detalleVentaRepo.deleteById(id);
	}
}
