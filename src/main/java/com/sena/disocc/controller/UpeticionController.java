package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Peticion;
import com.sena.disocc.service.PeticionService;

@Controller
@RequestMapping("/Dashboard/usuario")
public class UpeticionController {

	@Autowired
	PeticionService peticionService;

	@GetMapping("/peticion/listar")
	public String list(Model modelo) {
		modelo.addAttribute("peticion", peticionService.listAllPeticiones());
		return "Dashboard/peticion/peticionListar";
	}

	@GetMapping("/peticion/crear")
	public String formularioGuardar(Model modelo) {
		Peticion peticion = new Peticion();
		modelo.addAttribute("Peticion", peticion);
		return "Dashboard/peticion/peticionCrear";
	}

	@PostMapping("/peticion")
	public String guarduar(@ModelAttribute("peticion") Peticion peticion) {
		peticionService.savePeticiones(peticion);
		return "redirect:/Dashboard/usuario/peticion/listar";
	}

}
