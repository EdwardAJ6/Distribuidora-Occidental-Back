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
@Table(name ="ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENTA")
	private int idVenta;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "TOTAL")
	private long total;
	
	@Column(name = "PAGO_REALIZADO")
	private String pago_realizado;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
	private Productos producto;
	
	@OneToMany(targetEntity = DetalleVenta.class, mappedBy = "venta")
	private List<DetalleVenta> listaDetalleVentas;
}
