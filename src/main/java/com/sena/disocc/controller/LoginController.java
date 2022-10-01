package com.sena.disocc.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.repository.UsuarioRepository;
import com.sena.disocc.service.UsuarioService;



@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@Autowired
	private UsuarioService usuarioService;


	@GetMapping("/registro")
	public String mostrarFormularioDeRegistro(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "register";
	}
	
	@PostMapping("/procesar")
	public String registrarCuentaDeUsuario(Usuario usuario) 
	throws UnsupportedEncodingException, MessagingException {
		
	usuarioService.registerDefaultUser(usuario);
	usuarioService.sendEmailVerificacion(usuario);
		return "registroExitoso";
	}

}
