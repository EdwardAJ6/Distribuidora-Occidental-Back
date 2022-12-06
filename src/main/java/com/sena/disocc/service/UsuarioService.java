package com.sena.disocc.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.modelo.TipoDocumento;
import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.repository.RolRepository;
import com.sena.disocc.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usurepo;

	@Autowired
	RolRepository roleRepo;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;

	public List<Usuario> listAllUsuarios() {
		return usurepo.findAll();
	}

	public void saveUsuario(Usuario usu) {
		usurepo.save(usu);
	}

	public Usuario findById(Integer id) {
		return usurepo.findById(id).get();
	}

	public void deleteUsuario(Integer id) {
		usurepo.deleteById(id);
	}

	public Usuario findByEmail(String email) {
		return usurepo.findByEmail(email);
	}

	public void registerDefaultUser(Usuario usuario) {	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPassWord = encoder.encode(usuario.getContrasena());
		usuario.setContrasena(encoderPassWord);
		
		
		Rol roleUser = roleRepo.findByname("User");
		usuario.addRole(roleUser);
		
		usurepo.save(usuario);		
	}

	public void sendEmailVerificacion(Usuario usuario) 
		throws UnsupportedEncodingException, MessagingException {
	
		String subject ="Distribuidora Occidental";
		String senderNmae ="Distribuidora Occidental";
		String mailContent ="<p>Un gusto "+ usuario.Fullname();
		mailContent += "<p> Gracias por Registrarse en nuestro sistema";
		
		MimeMessage message =mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("ivanciclista2@gmail.com",senderNmae);
		helper.setTo(usuario.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent,true);
		mailSender.send(message);
		
	}
	
	public List<Usuario> findByTipoDocumento(TipoDocumento tipoDocumento){
		return usurepo.findByTipoDocumento(tipoDocumento);
	}
	
	

}
