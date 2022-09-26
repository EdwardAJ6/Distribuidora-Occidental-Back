package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.service.RolService;

@Controller
@RequestMapping("/Dashboard/admin")
public class RolController {

	@Autowired
	RolService rolService;
	
	@GetMapping("/rol")
	public String list(Model modelo) {
		modelo.addAttribute("rol", rolService.listAllRol());
		return "Dashboard/rol/rolListar";
	}

	@GetMapping("/rol/nuevo")
	public String formularioGuardar(Model modelo) {
		Rol rol = new Rol();
		modelo.addAttribute("rol", rol);
		return "Dashboard/rol/rolCrear";
	}

	@PostMapping("/rol")
	public String guardar(@ModelAttribute("rol") Rol rol) {
		rolService.saveRol(rol);
		return "redirect:marcaListar";
	}
	
	@GetMapping("/rol/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("rol", rolService.findById(id));
		return "Dashboard/rol/rolEditar";
	}
	
	@PostMapping("/rol/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("rol") Rol rol) {
		Rol rolExistente = rolService.findById(id);
		rolExistente.setIdRol(id);
		rolExistente.setNomRol(rol.getNomRol());
		rolService.saveRol(rolExistente);
		return "redirect:/Dashboard/rol/rolListar";
	}
	
	@GetMapping("/rol/{id}")
	public String eliminar(@PathVariable int id) {
		rolService.deleteRol(id);
		return "redirect:/Dashboard/rol/rolListar";
	}
}
