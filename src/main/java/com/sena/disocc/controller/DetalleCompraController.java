package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sena.disocc.modelo.DetalleCompra;
import com.sena.disocc.service.DetalleCompraService;

@Controller
@RequestMapping("/Dashboard/admin")
public class DetalleCompraController {

	@Autowired
	DetalleCompraService detalleCompraService;

	@GetMapping("/detalleCompra")
	public String list(Model modelo) {
		modelo.addAttribute("detalleCompra", detalleCompraService.listAllDetallesCompra());
		return "Dashboard/detallecompras/detalleCompraListar";
	}

	@GetMapping("/detalleCompra/nuevo")
	public String formularioGuardar(Model modelo) {
		DetalleCompra detalleCompra = new DetalleCompra();
		modelo.addAttribute("detalleCompra", detalleCompra);
		return "Dashboard/detallecompras/detalleCompraCrear";
	}

	@PostMapping("/detalleCompra")
	public String guardar(@ModelAttribute("detalleCompra") DetalleCompra detalleCompra) {
		detalleCompraService.saveDetalleCompra(detalleCompra);
		return "redirect:/Dashboard/detallecompras/detalleCompraListar";
	}

	@GetMapping("/detalleCompra/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("detalleCompra", detalleCompraService.findById(id));
		return "Dashboard/detallecompras/detalleCompraEditar";
	}

	@PostMapping("/detalleCompra/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("detalleCompra") DetalleCompra detalleCompra) {
		DetalleCompra detalleCompraExitente = detalleCompraService.findById(id);
		detalleCompraExitente.setIdCompra(id);
		detalleCompraExitente.setFecha(detalleCompra.getFecha());
		detalleCompraExitente.setPrecioProducto(detalleCompra.getPrecioProducto());
		detalleCompraExitente.setCantidad(detalleCompra.getCantidad());
		detalleCompraExitente.setSubtotal(detalleCompra.getSubtotal());
		detalleCompraExitente.setIva(detalleCompra.getIva());
		detalleCompraExitente.setTotal(detalleCompra.getTotal());
		detalleCompraService.saveDetalleCompra(detalleCompraExitente);
		return "redirect:/Dashboard/detallecompras/detalleCompraListar";
	}

	@GetMapping("/detalleCompra/{id}")
	public String eliminar(@PathVariable int id) {
		detalleCompraService.deleteDetalleCompra(id);
		return "redirect:/Dashboard/detallecompras/detalleCompraListar";
	}
}
