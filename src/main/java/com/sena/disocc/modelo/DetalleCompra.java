package com.sena.disocc.modelo;

import java.util.Date;

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
@Table(name="detalles_compras")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DETALLE_COMPRA")
	private int idCompra;
	@Column(name="FECHA")
	private Date fecha;
	@Column(name="PRECIO_PRODUCTO")
	private long precioProducto;
	@Column(name="CANTIDAD")
	private int cantidad;
	@Column(name="SUBTOTAL")
	private long subtotal;
	@Column(name="IVA")
	private int iva;
	@Column(name="TOTAL")
	private long total;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_COMPRA", referencedColumnName = "ID_COMPRA")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
	private Productos productos;
	
}
