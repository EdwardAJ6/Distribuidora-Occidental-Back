package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.service.RespuestaService;

@Controller
@RequestMapping("/Dashboard/usuario")
public class UrespuestaController {

	@Autowired
	RespuestaService resService;
	
	@GetMapping("/respuesta/listar")
	public String list(Model modelo) {
		modelo.addAttribute("respuesta", resService.listaAllRespuestas());
		return "Dashboard/respuesta/respuestaListar";
	}

}
