package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sena.disocc.modelo.TipoDocumento;
import com.sena.disocc.service.UsuarioService;
import com.sena.disocc.utilitis.MailSend;

@Controller
@RequestMapping("/Dashboard/admin/anuncio")
public class AnuncioController {
	
	@Autowired
	private MailSend mailSend;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(" ")
	public String mostraranuncio() {		
		return "Dashboard/anuncio/anuncio";
	}
	
	@PostMapping("/enviarAnuncio")
    public String sendMail(@RequestParam("subject") String subject, @RequestParam("body") String body){
		TipoDocumento tipodoc = new TipoDocumento();
		tipodoc.setIdTipoDocumento(2);
		mailSend.notificarUsuario(usuarioService.findByTipoDocumento(tipodoc),subject,body);

        return "redirect:/Dashboard/admin";
    }
}
