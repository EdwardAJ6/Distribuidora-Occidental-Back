package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.service.DetalleVentaService;

@Controller
@RequestMapping("/Dashboard/usuario")
public class UdetalleVentaController {
	
	@Autowired
	DetalleVentaService detalleVentaService;
	@GetMapping("/detalleVenta/listar")
	
	public String list(Model modelo) {
		modelo.addAttribute("detalleVenta", detalleVentaService.listAllDetallesVenta());
		return "Dashboard/detalleventas/detalleventasListar";
	}
	

}
