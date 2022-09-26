package com.sena.disocc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Venta;
import com.sena.disocc.repository.VentaRepository;

@Service
@Transactional
public class VentaService {
	@Autowired
	private VentaRepository ventarepo;
	
	public List<Venta> listAllVenta(){
		return ventarepo.findAll();
	}
	
	public void saveVenta (Venta venta) {
		ventarepo.save(venta);	
	}
	
	public Venta findById(Integer id) {
		return ventarepo.findById(id).get();
	}
	
	public void deleteVenta(Integer id) {
		ventarepo.deleteById(id);
	}
}
