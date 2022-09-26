package com.sena.disocc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_RESPUESTA")
	private int idRespuesta;
	@Column(name = "DESCRIPCION")
	public String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PETICION", referencedColumnName = "ID_PETICION")
	public Peticion FK_ID_PETICION;
	
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO")
	public Usuario FK_ID_USUARIO;
	
}
