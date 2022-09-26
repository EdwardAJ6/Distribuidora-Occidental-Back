package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.DetalleVenta;
import com.sena.disocc.service.DetalleVentaService;

@Controller
@RequestMapping("/Dashboard/admin")
public class DetalleVentaController {

	@Autowired
	DetalleVentaService detalleVentaService;

	@GetMapping("/detalleVenta/listar")
	public String list(Model modelo) {
		modelo.addAttribute("detalleVenta", detalleVentaService.listAllDetallesVenta());
		return "Dashboard/detalleventas/detalleventasListar";
	}

	@GetMapping("/detalleVenta/crear")
	public String formularioGuardar(Model modelo) {
		DetalleVenta detalleVenta = new DetalleVenta();
		modelo.addAttribute("detalleVenta", detalleVenta);
		return "Dashboard/detalleventas/detalleventasCrear";
	}

	@PostMapping("/detalleVenta")
	public String guardar(@ModelAttribute("detalleVenta") DetalleVenta detalleVenta) {
		detalleVentaService.saveDetalleVenta(detalleVenta);
		return "redirect:/Dashboard/detalleventas/detalleventaslistar";
	}
	
	@GetMapping("/detalleVenta/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("detalleVenta", detalleVentaService.findById(id));
		return "Dashboard/detalleventas/detalleventasEditar";
	}

	@PostMapping("/detalleVenta/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("detalleVenta") DetalleVenta detalleVenta) {
		DetalleVenta detalleVentaExitente = detalleVentaService.findById(id);
		detalleVentaExitente.setIdDetalleVenta(id);
		detalleVentaExitente.setFecha(detalleVenta.getFecha());
		detalleVentaExitente.setCantidad(detalleVenta.getCantidad());
		detalleVentaExitente.setPrecio_producto(detalleVenta.getPrecio_producto());	
		detalleVentaExitente.setSubtotal(detalleVenta.getSubtotal());
		detalleVentaExitente.setIva(detalleVenta.getIva());
		detalleVentaExitente.setTotal(detalleVenta.getTotal());
		detalleVentaExitente.setVenta(detalleVenta.getVenta());
		detalleVentaService.saveDetalleVenta(detalleVentaExitente);
		return "redirect:/Dashboard/detalleventas/detalleventasListar";
	}

	@GetMapping("/detalleVenta/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		detalleVentaService.deleteDetalle(id);
		return "redirect:Dashboard/detalleventas/detalleventasListar";
	}

}
