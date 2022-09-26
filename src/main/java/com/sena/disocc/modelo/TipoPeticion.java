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
@Table(name = "tipo_peticiones")
public class TipoPeticion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_PETICION")
	private int idTipoPeticion;
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToMany(targetEntity = Peticion.class, mappedBy = "tipopeticion")
	private List<Peticion>listaPeticion;
}
