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
@Table(name = "peticiones")
public class Peticion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PETICION")
	private int idPeticion;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_TIPO_PETICION", referencedColumnName = "ID_TIPO_PETICION")
	private TipoPeticion tipopeticion;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;
	
	@OneToMany(targetEntity = Respuesta.class, mappedBy = "FK_ID_PETICION")
	private List<Respuesta>listaRespuesta;

	
}
