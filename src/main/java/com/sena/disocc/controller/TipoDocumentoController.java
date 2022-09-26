package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.TipoDocumento;
import com.sena.disocc.service.TipoDocumentoService;

@Controller
@RequestMapping("/Dashboard/admin")
public class TipoDocumentoController {

	@Autowired
	TipoDocumentoService tdService;
	
	@GetMapping("/tipoDocumento/listar")
	public String list(Model modelo) {
		modelo.addAttribute("tipoDocumento", tdService.listAllTipoDoc());
		return "Dashboard/tipodocumento/tipodocumentoListar";
	}

	@GetMapping("/tipoDocumento/crear")
	public String formularioGuardar(Model modelo) {
		TipoDocumento tipoDocumento = new TipoDocumento();
		modelo.addAttribute("tipoDocumento", tipoDocumento);
		return "Dashboard/tipodocumento/tipodocumentoCrear";
	}

	@PostMapping("/tipoDocumento")
	public String guardar(@ModelAttribute("tipoDocumento") TipoDocumento tipoDocumento) {
		tdService.saveTipoDoc(tipoDocumento);
		return "redirect:/Dashboard/tipodocumento/tipodocumentoListar";
	}	
	
	@GetMapping("/tipoDocumento/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("tipoDocumento", tdService.findById(id));
		return "Dashboard/tipodocumento/tipodocumentoEditar";
	}
	
	@PostMapping("/tipoDocumento/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("tipoDocumento") TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoExistente = tdService.findById(id);
		tipoDocumentoExistente.setIdTipoDocumento(id);
		tipoDocumentoExistente.setNombreDocumento(tipoDocumento.getNombreDocumento());
		tipoDocumentoExistente.setSiglas(tipoDocumento.getSiglas());
		tdService.saveTipoDoc(tipoDocumentoExistente);
		return "redirect:/Dashboard/tipodocumento/tipodocumentoListar";
	}
	
	@GetMapping("/tipoDocumento/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		tdService.deleteTipoDoc(id);
		return "redirect:/Dashboard/tipodocumento/tipodocumentoListar";
	}
}

