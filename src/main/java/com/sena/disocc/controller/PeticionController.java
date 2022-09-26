package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Peticion;
import com.sena.disocc.service.PeticionService;

@Controller
@RequestMapping("/Dashboard/admin")
public class PeticionController {

	@Autowired
	PeticionService peticionService;

	@GetMapping("/peticion")
	public String list(Model modelo) {
		modelo.addAttribute("peticion", peticionService.listAllPeticiones());
		return "Dashboard/peticion/peticionListar";
	}

	@GetMapping("/peticion/nuevo")
	public String formularioGuardar(Model modelo) {
		Peticion peticion = new Peticion();
		modelo.addAttribute("Peticion", peticion);
		return "Dashboard/peticion/peticionCrear";
	}

	@PostMapping("/peticion")
	public String guarduar(@ModelAttribute("peticion") Peticion peticion) {
		peticionService.savePeticiones(peticion);
		return "redirect:/Dashboard/peticion/peticionListar";
	}
	
	@GetMapping("/peticion/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("peticion", peticionService.findById(id));
		return "Dashboard/peticion/peticionEditar";
	}
	
	@PostMapping("/peticion/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("peticion") Peticion peticion) {
		Peticion peticionExistente = peticionService.findById(id);
		peticionExistente.setIdPeticion(id);
		peticionExistente.setDescripcion(peticion.getDescripcion());
		peticionExistente.setTipopeticion(peticion.getTipopeticion());
		peticionExistente.setUsuario(peticion.getUsuario());
		peticionService.savePeticiones(peticionExistente);
		return "redirect:/Dashboard/peticion/peticionListar";
	}
	
	@GetMapping("/peticion/{id}")
	public String eliminar(@PathVariable int id) {
		peticionService.eliminar(id);
		return "redirect:/Dashboard/peticion/peticionListar";
	}
}
