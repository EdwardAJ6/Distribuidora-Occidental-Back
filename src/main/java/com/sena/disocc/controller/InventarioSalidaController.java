package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.InventarioSalidas;
import com.sena.disocc.service.InventarioSalidaService;

@Controller
@RequestMapping("/Dashboard/admin")
public class InventarioSalidaController {

	@Autowired
	InventarioSalidaService inventarioSalidaService;

	@GetMapping("/inventarioSalida/listar")
	public String list(Model modelo) {
		modelo.addAttribute("inventarioSalida", inventarioSalidaService.listAllInventarioSalidas());
		return "Dashboard/inventariosalida/inventariosalidaListar";
	}

	@GetMapping("/inventarioSalida/crear")
	public String formularioGuardar(Model modelo) {
		InventarioSalidas inventarioSalidas = new InventarioSalidas();
		modelo.addAttribute("inventarioSalida", inventarioSalidas);
		return "Dashboard/inventariosalida/inventariosalidaCrear";
	}

	@PostMapping("/inventarioSalida")
	public String guardar(@ModelAttribute("inventarioSalida") InventarioSalidas inventarioSalidas) {
		inventarioSalidaService.saveInventarioSalidas(inventarioSalidas);
		return "redirect:/Dashboard/inventariosalida/inventariosalidaListar";
	}
	
	@GetMapping("/inventarioSalida/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("inventarioSaalida", inventarioSalidaService.findById(id));
		return "Dashboard/inventariosalida/inventariosalidaListar";
	}
	
	@PostMapping("/inventarioSalida/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("inventarioSalida") InventarioSalidas inventarioSalidas) {
		InventarioSalidas inventarioSalidaExistente = inventarioSalidaService.findById(id);
		inventarioSalidaExistente.setIdInventarioSalida(id);
		inventarioSalidaExistente.setDetalleVenta(inventarioSalidas.getDetalleVenta());
		inventarioSalidaExistente.setInventarios(inventarioSalidas.getInventarios());
		inventarioSalidaExistente.setCantidad(inventarioSalidas.getCantidad());
		inventarioSalidaExistente.setTotal(inventarioSalidas.getTotal());
		inventarioSalidaService.saveInventarioSalidas(inventarioSalidaExistente);
		return "redirect:/Dashboard/inventariosalida/inventariosalidaListar";
	}
	
	@GetMapping("/inventarioSalida/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		inventarioSalidaService.deleteInventarioSalidas(id);
		return "redirect:/Dashboard/inventariosalida/inventariosalidaListar";
	}
}
