package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sena.disocc.modelo.Permiso;
import com.sena.disocc.service.PermisoService;

@Controller
@RequestMapping("/Dashboard/admin")
public class PermisoController {

	@Autowired
	PermisoService permisoService;

	@GetMapping("/permiso")
	public String list(Model modelo) {
		modelo.addAttribute("permiso", permisoService.listAllPermiso());
		return "Dashboard/permisos/permisoListar";
	}

	@GetMapping("/permiso/nuevo")
	public String formularioGuardar(Model modelo) {
		Permiso permiso = new Permiso();
		modelo.addAttribute("permiso", permiso);
		return "Dashboard/permisos/permisoCrear";
	}

	@PostMapping("/permiso")
	public String guardar(@ModelAttribute("permiso") Permiso permiso) {
		permisoService.savePermiso(permiso);
		return "redirect:/Dashboard/permisos/permisoListar";
	}
	
	@GetMapping("/permiso/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("permiso", permisoService.findById(id));
		return "Dashboard/permisos/permisoEditar";
	}
	
	@PostMapping("/permiso/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("permiso") Permiso permiso) {
		Permiso permisoExistente = permisoService.findById(id);
		permisoExistente.setIdPermiso(id);
		permisoExistente.setDescripcion(permiso.getDescripcion());
		permisoService.savePermiso(permisoExistente);
		return "redirect:/Dashboard/permisos/permisoListar";
	}
	
	@GetMapping("/permiso/{id}")
	public String eliminar(@PathVariable int id) {
		permisoService.deletePermiso(id);
		return "redirect:/Dashboard/permisos/permisoListar";
	}
}
