package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Venta;
import com.sena.disocc.service.VentaService;

@Controller
@RequestMapping("/Dashboard/admin")
public class VentaController {

	@Autowired
	VentaService ventaService;
	
	@GetMapping("/venta/listar")
	public String list(Model modelo) {
		modelo.addAttribute("venta", ventaService.listAllVenta());
		return "Dashboard/ventas/ventasListar";
	}

	@GetMapping("/venta/crear")
	public String formularioGuardar(Model modelo) {
		Venta venta = new Venta();
		modelo.addAttribute("venta", venta);
		return "Dashboard/ventas/ventasCrear";
	}

	@PostMapping("/venta")
	public String guardar(@ModelAttribute("venta") Venta venta) {
		ventaService.saveVenta(venta);
		return "redirect:/Dashboard/ventas/ventasListar";
	}
	
	@GetMapping("/venta/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("venta", ventaService.findById(id));
		return "Dashboard/ventas/ventasEditar";
	}
	
	@PostMapping("/venta/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("venta") Venta venta) {
		Venta ventaExistente = ventaService.findById(id);
		ventaExistente.setIdVenta(id);
		ventaExistente.setFecha(venta.getFecha());
		ventaExistente.setPago_realizado(venta.getPago_realizado());
		ventaExistente.setUsuario(venta.getUsuario());
		ventaExistente.setProducto(venta.getProducto());
		ventaService.saveVenta(ventaExistente);
		return "redirect:/Dashboard/ventas/ventasListar";
	}
	
	@GetMapping("/venta/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		ventaService.deleteVenta(id);
		return "redirect:/Dashboard/ventas/ventasListar";
	}
}
