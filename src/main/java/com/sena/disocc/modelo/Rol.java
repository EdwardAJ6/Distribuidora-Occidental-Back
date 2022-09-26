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
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private int idRol;
	@Column(name = "NOM_ROL")
	private String nomRol;
	
	@OneToMany(targetEntity = Usuario.class, mappedBy = "idRol")
	private List<Usuario> listausuario;


}
