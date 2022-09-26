package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Inventarios;
import com.sena.disocc.service.InventarioService;

@Controller
@RequestMapping("/Dashboard/admin")
public class InventarioController {

	@Autowired
	InventarioService inventarioService;

	@GetMapping("/inventario/listar")
	public String list(Model modelo) {
		modelo.addAttribute("inventario", inventarioService.listAllInventarios());
		return "Dashboard/inventario/inventarioListar";
	}

	@GetMapping("/inventario/crear")
	public String formularioGuardar(Model modelo) {
		Inventarios inventario = new Inventarios();
		modelo.addAttribute("inventario", inventario);
		return "Dashboard/inventario/inventarioCrear";
	}

	@PostMapping("/inventario")
	public String guardar(@ModelAttribute("inventario") Inventarios inventarios) {
		inventarioService.saveInventarios(inventarios);
		return "redirect:/Dashboard/inventario/inventarioListar";
	}
	
	@GetMapping("/inventario/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("inventario", inventarioService.findById(id));
		return "Dashboard/estado/inventarioEditar";
	}
	
	@PostMapping("/inventario/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("estado") Inventarios inventarios) {
		Inventarios inventarioExistente = inventarioService.findById(id);
		inventarioExistente.setIdInventario(id);
		inventarioExistente.setNombre(inventarios.getNombre());
		inventarioService.saveInventarios(inventarioExistente);
		return "redirect:/Dashboard/inventario/inventarioListar";
	}
	
	@GetMapping("/inventario/editar/{id}")
	public String eliminar(@PathVariable int id) {
		inventarioService.deleteInventarios(id);
		return "redirect:/Dashboard/inventario/inventarioListar";
	}
}
