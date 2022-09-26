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
@Table(name = "tipos_documentos")
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_DOCUMENTO")
	private int idTipoDocumento;

	@Column(name = "NOMBRE_DOCUMENTO")
	private String nombreDocumento;

	@Column(name = "SIGLAS")
	private String siglas;

	@OneToMany(targetEntity = Usuario.class, mappedBy = "tipoDocumento")
	private List<Usuario> listaUsuarios;

}
