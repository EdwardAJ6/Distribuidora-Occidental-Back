package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Respuesta;
import com.sena.disocc.service.RespuestaService;

@Controller
@RequestMapping("/Dashboard/admin")
public class RespuestaController {

	@Autowired
	RespuestaService resService;
	
	@GetMapping("/respuesta/listar")
	public String list(Model modelo) {
		modelo.addAttribute("respuesta", resService.listaAllRespuestas());
		return "Dashboard/respuesta/respeustaListar";
	}

	@GetMapping("/respuesta/crear")
	public String formularioGuardar(Model modelo) {
		Respuesta respuesta = new Respuesta();
		modelo.addAttribute("respuesta", respuesta);
		return "Dashboard/respuesta/respuestaCrear";
	}

	@PostMapping("/respuesta")
	public String guardar(@ModelAttribute("respuesta") Respuesta respuesta) {
		resService.saveRespuestas(respuesta);
		return "redirect:/Dashboard/respuesta/respuestaListar";
	}
	
	@GetMapping("/respuesta/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("respuesta", resService.findById(id));
		return "Dashboard/respuesta/respuestaEditar";
	}
	
	@PostMapping("/respuesta/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("respuesta") Respuesta respuesta) {
		Respuesta respuestaExistente = resService.findById(id);
		respuestaExistente.setIdRespuesta(id);
		respuestaExistente.setDescripcion(respuesta.getDescripcion());
		respuestaExistente.setFK_ID_PETICION(respuesta.getFK_ID_PETICION());
		respuestaExistente.setFK_ID_USUARIO(respuesta.getFK_ID_USUARIO());
		resService.saveRespuestas(respuestaExistente);
		return "redirect:/Dashboard/respuesta/respuestaListar";
	}
	
	@GetMapping("/respuesta/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		resService.deleteRespuestas(id);
		return "redirect:/Dashboard/respuesta/respuestaListar";
	}
}
