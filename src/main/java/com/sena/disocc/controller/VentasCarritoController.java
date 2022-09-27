package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.repository.VentaRepository;

@Controller
@RequestMapping("Dashboard/admin/vendidos")
public class VentasCarritoController {

	  @Autowired
	    VentaRepository ventasRepository;

	    @GetMapping("/listar")
	    public String mostrarVentas(Model model) {
	        model.addAttribute("ventas", ventasRepository.findAll());
	        return "Dashboard/ver_ventas";
	    }
}
