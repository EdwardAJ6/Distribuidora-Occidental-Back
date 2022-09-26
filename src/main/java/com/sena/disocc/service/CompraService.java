package com.sena.disocc.service;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Compra;
import com.sena.disocc.repository.CompraRepository;

@Service
@Transactional
public class CompraService {
	@Autowired
	private CompraRepository compraRepository;

	public List<Compra> ListAllCompra() {
		return compraRepository.findAll();
	}

	public void saveCompra(Compra compra) {
		compraRepository.save(compra);
	}

	public Compra findById(Integer id) {
		return compraRepository.findById(id).get();
	}

	public void deleteCompra(Integer id) {
		compraRepository.deleteById(id);
	}
}
