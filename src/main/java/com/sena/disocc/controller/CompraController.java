package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sena.disocc.modelo.Compra;
import com.sena.disocc.service.CompraService;

@Controller
@RequestMapping("/Dashboard/admin")
public class CompraController {

	@Autowired
	CompraService compraService;

	@GetMapping("/compra/listar")
	public String list(Model modelo) {
		modelo.addAttribute("compra", compraService.ListAllCompra());
		return "Dashboard/compras/comprasListar";
	}

	@GetMapping("/compra/crear")
	public String formularioGuardar(Model modelo) {
		Compra compra = new Compra();
		modelo.addAttribute("compra", compra);
		return "Dashboard/compras/comprasCrear";
	}

	@PostMapping("/compra")
	public String guardar(@ModelAttribute("compra") Compra compra) {
		compraService.saveCompra(compra);
		return "redirect:/Dashboard/compras/comprasListar";
	}
	
	@GetMapping("/compra/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("compra", compraService.findById(id));
		return "Dashboard/compras/comprasEditar";
	}
	
	@PostMapping("/compra/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("compra") Compra compra) {
		Compra compraExistente = compraService.findById(id);
		compraExistente.setIdCompra(id);
		compraExistente.setFecha(compra.getFecha());
		compraExistente.setTotal(compra.getTotal());
		compraExistente.setPagoRealizado(compra.getPagoRealizado());
		compraService.saveCompra(compraExistente);
		return "redirect:/Dashboard/compras/comprasListar";
	}
	
	@GetMapping("/compra/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		compraService.deleteCompra(id);
		return "redirect:/Dashboard/compras/comprasListar";
	}
}
