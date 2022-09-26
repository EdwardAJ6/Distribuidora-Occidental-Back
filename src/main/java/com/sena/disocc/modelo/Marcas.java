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
@Table(name="marcas")
public class Marcas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MARCA")
	private int idMarca;
	
	@Column(name="NOMBRE_MARCA")
	private String nombreMarca;
	
	@OneToMany(targetEntity = Productos.class, mappedBy = "Marca")
	private List<Productos> listaMarcas;
}
