package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Usuario;
import com.sena.disocc.service.EstadoService;
import com.sena.disocc.service.RolService;
import com.sena.disocc.service.TipoDocumentoService;
import com.sena.disocc.service.UsuarioService;

@Controller
@RequestMapping("/Dashboard/admin")
public class UsuarioController {

	@Autowired
	UsuarioService ususervice;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	EstadoService estadoService;
	
	@Autowired
	TipoDocumentoService documentoService;
	
	@GetMapping("/usuario/listar")
	public String list(Model modelo) {
		modelo.addAttribute("usuario", ususervice.listAllUsuarios());
		return "Dashboard/usuarios/usuariosListar";
	}

	@GetMapping("/usuario/crear")
	public String formularioGuardar(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("tipodoc", documentoService.listAllTipoDoc());
		modelo.addAttribute("estado", estadoService.listAllEstado());
		modelo.addAttribute("rol", rolService.listAllRol());
		return "Dashboard/usuarios/usuariosCrear";
	}

	@PostMapping("/usuario")
	public String guardar(@ModelAttribute("usuario") Usuario usuario) {
		ususervice.saveUsuario(usuario);
		return "redirect:/Dashboard/admin/usuario/listar";
	}
	
	@GetMapping("/usuario/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("usuario", ususervice.findById(id));
		modelo.addAttribute("tipodoc", documentoService.listAllTipoDoc());
		modelo.addAttribute("estado", estadoService.listAllEstado());
		modelo.addAttribute("rol", rolService.listAllRol());
		return "Dashboard/usuarios/usuariosEditar";
	}
	
	@PostMapping("/usuario/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("usuario") Usuario usuario) {
		Usuario usuarioExistente = ususervice.findById(id);
		usuarioExistente.setIdUsuario(id);
		usuarioExistente.setContrasena(usuario.getContrasena());
		usuarioExistente.setEmail(usuario.getEmail());
		usuarioExistente.setDireccion(usuario.getDireccion());
		usuarioExistente.setNumeroDocumento(usuario.getNumeroDocumento());
		usuarioExistente.setPrimerApellido(usuario.getPrimerApellido());
		usuarioExistente.setPrimerNombre(usuario.getPrimerNombre());
		usuarioExistente.setSegundoApellido(usuario.getSegundoApellido());
		usuarioExistente.setSegundoNombre(usuario.getSegundoNombre());
		usuarioExistente.setTelefono(usuario.getTelefono());
		usuarioExistente.setTipoDocumento(usuario.getTipoDocumento());
		usuarioExistente.setRoles(usuario.getRoles());
		usuarioExistente.setIdEstado(usuario.getIdEstado());
		ususervice.saveUsuario(usuarioExistente);
		return "redirect:/Dashboard/usuarios/usuariosListar";
	}
	
	@GetMapping("/usuario/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		ususervice.deleteUsuario(id);
		return "redirect:/Dashboard/usuarios/usuariosListar";
	}
}
