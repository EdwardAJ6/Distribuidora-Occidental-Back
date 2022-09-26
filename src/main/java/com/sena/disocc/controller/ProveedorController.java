package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Proveedor;
import com.sena.disocc.service.ProveedorService;

@Controller
@RequestMapping("/Dashboard/admin")
public class ProveedorController {

	@Autowired
	ProveedorService proveedorService;

	@GetMapping("/proveedor/listar")
	public String list(Model modelo) {
		modelo.addAttribute("proveedor", proveedorService.listAllProveedor());
		return "Dashboard/proveedor/proveedorListar";
	}

	@GetMapping("/proveedor/crear")
	public String formularioGuardar(Model modelo) {
		Proveedor proveedor = new Proveedor();
		modelo.addAttribute("proveedor", proveedor);
		return "Dashboard/proveedor/proveedorCrear";
	}

	@PostMapping("/proveedor")
	public String guardar(@ModelAttribute("proveedor") Proveedor proveedor) {
		proveedorService.saveProveedor(proveedor);
		return "redirect:/Dashboard/admin/proveedor/listar";
	}
	
	@GetMapping("/proveedor/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("proveedor", proveedorService.findById(id));
		return "Dashboard/proveedor/proveedorEditar";
	}
	
	@PostMapping("/proveedor/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("proveedor") Proveedor proveedor) {
		Proveedor proveedorExistente = proveedorService.findById(id);
		proveedorExistente.setIdProveedor(id);
		proveedorExistente.setNombreProveedor(proveedor.getNombreProveedor());
		proveedorExistente.setNitProveedor(proveedor.getNitProveedor());
		proveedorExistente.setDireccion(proveedor.getDireccion());
		proveedorExistente.setTelefono(proveedor.getTelefono());
		proveedorExistente.setCorreo(proveedor.getCorreo());
		proveedorService.saveProveedor(proveedorExistente);
		return "redirect:/Dashboard/admin/proveedor/listar";
	}
	
	@GetMapping("/proveedor/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		proveedorService.deleteProveedor(id);
		return "redirect:/Dashboard/admin/proveedor/listar";
	}
}
