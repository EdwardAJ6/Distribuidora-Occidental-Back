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
@Table(name = "inventario_entradas")
public class InventarioEntradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInventarioEntrada;

	@Column(name = "CANTIDAD")
	private int cantidad;

	@Column(name = "TOTAL")
	private long total;

	@ManyToOne
	@JoinColumn(name = "FK_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
	private Productos productos;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
	private Inventarios inventarios;
	
}
