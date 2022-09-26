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
@Table(name = "inventarios")
public class Inventarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INVENTARIO")
	private int idInventario;

	@Column(name = "NOMBRE")
	private String nombre;

	@OneToMany(targetEntity = InventarioSalidas.class, mappedBy = "inventarios")
	private List<InventarioSalidas> listaInventarioSalidas;
	
	@OneToMany(targetEntity = InventarioEntradas.class, mappedBy = "inventarios")
	private List<InventarioEntradas> listaEntradas;

}
