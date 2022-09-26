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
@Table(name="productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private int idProducto;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PRECIO_UNIDAD")
	private long precioUnidad;
	
	@Column(name="STOCK_DISPONIBLE")
	private int stockDisponible;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="FECHA_VENCIMIENTOD")
	private Date fechaVencimiento;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_MARCA", referencedColumnName = "ID_MARCA")
	private Marcas Marca;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_CATEGORIA_PRODUCTO", referencedColumnName = "ID_CATEGORIA")
	private CategoriasProductos CategoriaProducto;
	
	@OneToMany(targetEntity = DetalleCompra.class, mappedBy = "productos")
	private List<DetalleCompra> listaDetallecompra;
	
	@OneToMany(targetEntity = Venta.class, mappedBy = "producto")
	private List<Venta> listaVentas;
	
	@OneToMany(targetEntity = InventarioEntradas.class, mappedBy = "productos")
	private List<InventarioEntradas> listaEntradas;

}
