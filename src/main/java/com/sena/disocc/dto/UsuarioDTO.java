package com.sena.disocc.dto;

import com.sena.disocc.modelo.TipoDocumento;

import lombok.Data;

@Data
public class UsuarioDTO {


	private int idUsuario;	
	private String contrasena;
	private String email;
	private String direccion;
	private int numeroDocumento;
	private String primerApellido;
	private String primerNombre;
	private String segundoApellido;
	private String segundoNombre;
	private int telefono;
	private TipoDocumento tipoDocumento;
	
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(String contrasena, String email, String direccion, int numeroDocumento, String primerApellido,
			String primerNombre, String segundoApellido, String segundoNombre, int telefono,TipoDocumento tipoDocumento) {
		super();
		this.contrasena = contrasena;
		this.email = email;
		this.direccion = direccion;
		this.numeroDocumento = numeroDocumento;
		this.primerApellido = primerApellido;
		this.primerNombre = primerNombre;
		this.segundoApellido = segundoApellido;
		this.segundoNombre = segundoNombre;
		this.telefono = telefono;
		this.tipoDocumento= tipoDocumento;
	}
	
	
}
