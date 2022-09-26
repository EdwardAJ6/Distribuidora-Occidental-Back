package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.service.RolService;
import com.sena.disocc.service.UsuarioService;

@Controller
@RequestMapping("Dashboard/admin")
public class Home {
	
	
	@GetMapping("")
	public String homdos() {
		return "inicioAdmin";
		
	}
	
}
