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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_COMPRA")
	private int idCompra;
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	@Column(name="TOTAL")
	private long total;
	@Column(name="PAGO_REALIZADO")
	private String pagoRealizado;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
	private Proveedor proveedor;
	
	@OneToMany(targetEntity = DetalleCompra.class, mappedBy = "compra")
	private List<DetalleCompra> listaDetallecompra;

}
