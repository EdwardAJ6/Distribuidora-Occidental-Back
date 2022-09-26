package com.sena.disocc.modelo;

import java.util.Date;
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
@Table(name = "detalles_ventas")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DETALLE_VENTA")
	private int idDetalleVenta;
	@Column(name = "FECHA")
	private Date fecha;
	@Column(name = "CANTIDAD")
	private int cantidad;
	@Column(name = "PRECIO_PRODUCTO")
	private long precio_producto;
	@Column(name = "SUBTOTAL")
	private long subtotal;
	@Column(name = "IVA")
	private int iva;
	@Column(name = "TOTAL")
	private long total;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_VENTA", referencedColumnName = "ID_VENTA")
	private Venta venta;
	
	@OneToMany(targetEntity = InventarioSalidas.class, mappedBy = "detalleVenta")
	private List<InventarioSalidas> listaInventarioSalidas;


}
