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
@Table(name = "inventario_salidas")
public class InventarioSalidas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInventarioSalida;

	@Column(name = "CANTIDAD")
	private int cantidad;

	@Column(name = "TOTAL")
	private long total;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
	private Inventarios inventarios;

	@ManyToOne
	@JoinColumn(name = "FK_ID_DETALLE_VENTA", referencedColumnName = "ID_DETALLE_VENTA")
	private DetalleVenta detalleVenta;


}
