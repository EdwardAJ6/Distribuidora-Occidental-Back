package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sena.disocc.modelo.Estado;
import com.sena.disocc.service.EstadoService;

@Controller
@RequestMapping("/Dashboard/admin")
public class EstadoController {

	@Autowired
	EstadoService estadoService;

	@GetMapping("/estado/listar")
	public String list(Model modelo) {
		modelo.addAttribute("estado", estadoService.listAllEstado());
		return "Dashboard/estado/estadoListar";
	}

	@GetMapping("/estado/crear")
	public String formularioGuardar(Model modelo) {
		Estado estado = new Estado();
		modelo.addAttribute("estado", estado);
		return "Dashboard/estado/estadoCrear";
	}

	@PostMapping("/estado")
	public String guardar(@ModelAttribute("estado") Estado estado) {
		estadoService.saveEstado(estado);
		return "redirect:/Dashboard/estado/estadoListar";
	}
	
	@GetMapping("/estado/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("estado", estadoService.findById(id));
		return "Dashboard/estado/estadoEditar";
	}
	
	@PostMapping("/estado/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("estado") Estado estado) {
		Estado estadoExistente = estadoService.findById(id);
		estadoExistente.setIdEstado(id);
		estadoExistente.setNombre(estado.getNombre());
		estadoService.saveEstado(estadoExistente);
		return "redirect:/Dashboard/estado/estadoListar";
	}
	
	@GetMapping("/estado/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		estadoService.deleteEstado(id);
		return "redirect:/Dashboard/estado/estadoListar";
	}
}
