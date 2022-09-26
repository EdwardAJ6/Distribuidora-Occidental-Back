package com.sena.disocc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.disocc.modelo.TipoDocumento;
import com.sena.disocc.repository.TipoDocumentoRepository;

@Service
@Transactional
public class TipoDocumentoService {
	
	@Autowired
	private TipoDocumentoRepository tipodocRepo;
	
	public List<TipoDocumento> listAllTipoDoc(){
		return tipodocRepo.findAll();
	}
	
	public void saveTipoDoc(TipoDocumento tipodoc) {
		
		tipodocRepo.save(tipodoc);
	}
	
	public TipoDocumento findById(Integer id) {
		return tipodocRepo.findById(id).get();
	}
	
	public void deleteTipoDoc(Integer id) {
		tipodocRepo.deleteById(id);
	}

}
