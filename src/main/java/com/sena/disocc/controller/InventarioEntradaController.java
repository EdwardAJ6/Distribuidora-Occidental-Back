package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.InventarioEntradas;
import com.sena.disocc.service.InventarioEntradaService;

@Controller
@RequestMapping("/Dashboard/admin")
public class InventarioEntradaController {

	@Autowired
	InventarioEntradaService inventarioEntradaService;

	@GetMapping("/inventarioEntrada")
	public String list(Model modelo) {
		modelo.addAttribute("inventarioEntrada", inventarioEntradaService.listAllInventarioEntradas());
		return "Dashboard/inventarioentrada/inventarioEntradaListar";
	}

	@GetMapping("/inventarioEntrada/nuevo")
	public String formularioGuardar(Model modelo) {
		InventarioEntradas inventarioEntrada = new InventarioEntradas();
		modelo.addAttribute("inventarioEntrada", inventarioEntrada);
		return "Dashboard/inventarioentrada/inventarioEntradaCrear";
	}

	@PostMapping("/inventarioEntrada")
	public String guardar(@ModelAttribute("inventarioEntrada") InventarioEntradas inventarioEntradas) {
		inventarioEntradaService.saveInventarioEntradas(inventarioEntradas);
		return "redirect:/Dashboard/inventarioentrada/inventarioEntradaListar";
	}
	
	@GetMapping("/inventarioEntrada/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("inventarioEntrada", inventarioEntradaService.findById(id));
		return "Dashboard/inventarioentrada/inventarioEntradaListar";
	}
	
	@PostMapping("/inventarioEntrada/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("inventarioEntrada") InventarioEntradas inventarioEntradas) {
		InventarioEntradas inventarioEntradaExistente = inventarioEntradaService.findById(id);
		inventarioEntradaExistente.setIdInventarioEntrada(id);
		inventarioEntradaExistente.setProductos(inventarioEntradas.getProductos());
		inventarioEntradaExistente.setInventarios(inventarioEntradas.getInventarios());
		inventarioEntradaExistente.setCantidad(inventarioEntradas.getCantidad());
		inventarioEntradaExistente.setTotal(inventarioEntradas.getTotal());
		inventarioEntradaService.saveInventarioEntradas(inventarioEntradaExistente);
		return "redirect:/Dashboard/inventarioentrada/inventarioEntradaListar";
	}
	
	@GetMapping("/inventarioEntrada/{id}")
	public String eliminar(@PathVariable int id) {
		inventarioEntradaService.deleteInventarioEntradas(id);
		return "redirect:/Dashboard/inventarioentrada/inventarioEntradaListar";
	}

}
