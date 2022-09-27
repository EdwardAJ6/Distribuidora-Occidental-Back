package com.sena.disocc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {

	@GetMapping(" ")
	public String irlogin() {		
		return "login";
	}	
	@GetMapping("/registrar")
	public String irregistrer() {		
		return "register";
	}
}
