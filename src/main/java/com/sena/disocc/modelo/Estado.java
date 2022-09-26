package com.sena.disocc.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "estados")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTADO")
	private int idEstado;

	@Column(name = "NOMBRE")
	private String nombre;

	@OneToMany(targetEntity = Usuario.class, mappedBy = "idEstado")
	private List<Usuario> listausuario;
}
