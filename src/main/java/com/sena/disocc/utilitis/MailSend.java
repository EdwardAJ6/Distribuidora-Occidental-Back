package com.sena.disocc.utilitis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Usuario;

@Service
public class MailSend {

	@Autowired
	private JavaMailSender mailSender;
	
	public void notificarUsuario( List<Usuario> listaUsuarios, String subject,String body) {
		
		 for (Usuario usu : listaUsuarios){
	         
	            SimpleMailMessage email = new SimpleMailMessage();
	            email.setTo(usu.getEmail());
	            email.setSubject(subject);
	            email.setText(body);

	            mailSender.send(email);
	    }
	}
}
