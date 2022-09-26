package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.TipoPeticion;
import com.sena.disocc.service.TipoPeticionService;

@Controller
@RequestMapping("/Dashboard/admin")
public class TipoPeticionController {

	@Autowired
	TipoPeticionService tipoPeticionService;
	
	@GetMapping("/tipoPeticion")
	public String list(Model modelo) {
		modelo.addAttribute("tipoPeticion", tipoPeticionService.listAllTipoPeticiones());
		return "Dashboard/tipopeticion/tipoPeticionListar";
	}

	@GetMapping("/tipoPeticion/nuevo")
	public String formularioGuardar(Model modelo) {
		TipoPeticion tipoPeticion = new TipoPeticion();
		modelo.addAttribute("tipoPeticion", tipoPeticion);
		return "Dashboard/tipopeticion/tipoPeticionCrear";
	}

	@PostMapping("/tipoPeticion")
	public String guardar(@ModelAttribute("tipoPeticion") TipoPeticion tipoPeticion) {
		tipoPeticionService.saveTipoPeticiones(tipoPeticion);
		return "redirect:/Dashboard/tipopeticion/tipoPeticionListar";
	}
	
	@GetMapping("/tipoPeticion/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("tipoPeticion", tipoPeticionService.findById(id));
		return "Dashboard/tipopeticion/tipoPeticionEditar";
	}
	
	@PostMapping("/tipoPeticion/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("tipoPeticion") TipoPeticion tipoPeticion) {
		TipoPeticion tipoPeticionExistente = tipoPeticionService.findById(id);
		tipoPeticionExistente.setIdTipoPeticion(id);
		tipoPeticionExistente.setNombre(tipoPeticion.getNombre());
		tipoPeticionService.saveTipoPeticiones(tipoPeticionExistente);
		return "redirect:/Dashboard/tipopeticion/tipoPeticionListar";
	}
	
	@GetMapping("/tipoPeticion/{id}")
	public String eliminar(@PathVariable int id) {
		tipoPeticionService.deleteTipoPeticiones(id);
		return "redirect:/Dashboard/tipopeticion/tipoPeticionListar";
	}
}
