package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Marcas;
import com.sena.disocc.service.MarcasService;

@Controller
@RequestMapping("/Dashboard/admin")
public class MarcasController {

	@Autowired
	MarcasService marcasService;

	@GetMapping("/marca/listar")
	public String list(Model modelo) {
		modelo.addAttribute("marca", marcasService.listAllMarcas());
		return "Dashboard/marca/marcaListar";
	}

	@GetMapping("/marca/crear")
	public String formularioGuardar(Model modelo) {
		Marcas marca = new Marcas();
		modelo.addAttribute("marca", marca);
		return "Dashboard/marca/marcaCrear";
	}

	@PostMapping("/marca")
	public String guardar(@ModelAttribute("marca") Marcas marcas) {
		marcasService.saveMarcas(marcas);
		return "redirect:/Dashboard/admin/marca/listar";
	}
	
	@GetMapping("/marca/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("marca", marcasService.findById(id));
		return "Dashboard/marca/marcaEditar";
	}
	
	@PostMapping("/marca/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("marca") Marcas marcas) {
		Marcas marcaExistente = marcasService.findById(id);
		marcaExistente.setIdMarca(id);
		marcaExistente.setNombreMarca(marcas.getNombreMarca());
		marcasService.saveMarcas(marcaExistente);
		return "redirect:/Dashboard/admin/marca/listar";
	}
	
	@GetMapping("/marca/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		marcasService.deleteMarcas(id);
		return "redirect:/Dashboard/admin/marca/listar";
	}
}
