package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sena.disocc.service.VentaService;

@Controller
@RequestMapping("/Dashboard/usuario")
public class UventaController {
	
	@Autowired
	VentaService ventaService;
	
	@GetMapping("/venta/listar")
	public String list(Model modelo) {
		modelo.addAttribute("venta", ventaService.listAllVenta());
		return "Dashboard/ventas/ventasListar";
	}

}
