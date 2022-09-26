package com.sena.disocc.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int idUsuario;
	@Column(name = "CONTRASENA")
	private String contrasena;
	@Column(name = "CORREO")
	private String correo;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "NUMERO_DOCUMENTO")
	private int numeroDocumento;
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column(name = "TELEFONO")
	private int telefono;
	
	@ManyToOne
	@JoinColumn(name = "FK_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
	private TipoDocumento tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_ROL", referencedColumnName = "ID_ROL")
	private Rol idRol;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_ESTADO", referencedColumnName = "ID_ESTADO")
	private Estado idEstado;
	
	@OneToMany(targetEntity = Peticion.class, mappedBy = "usuario")
	private List<Peticion> listaPeticio;
	
	@OneToMany(targetEntity = Respuesta.class, mappedBy = "FK_ID_USUARIO")
	private List<Respuesta>listaRespuesta;
	
	@OneToMany(targetEntity = Venta.class, mappedBy = "usuario")
	private List<Venta> listaVentas;


}
