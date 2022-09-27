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
	private Float precioUnidad;
	
	@Column(name="STOCK_DISPONIBLE")
	private int stockDisponible;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="CODIGO")
	private String codigo;
	
	@Column(name="FECHA_VENCIMIENTOD")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	
	 public boolean sinExistencia() {
	        return this.stockDisponible <= 0;
	    }

	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Productos(int idProducto, String nombre, Float precioUnidad, int stockDisponible, String descripcion,
			Date fechaVencimiento, Marcas marca, CategoriasProductos categoriaProducto,
			List<DetalleCompra> listaDetallecompra, List<Venta> listaVentas, List<InventarioEntradas> listaEntradas, String codigo ) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioUnidad = precioUnidad;
		this.stockDisponible = stockDisponible;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
		Marca = marca;
		CategoriaProducto = categoriaProducto;
		this.listaDetallecompra = listaDetallecompra;
		this.listaVentas = listaVentas;
		this.listaEntradas = listaEntradas;
		this.codigo = codigo;
	}
	

	public Productos(String nombre, Float precioUnidad, int stockDisponible, String descripcion, Date fechaVencimiento,
			Marcas marca, CategoriasProductos categoriaProducto, List<DetalleCompra> listaDetallecompra,
			List<Venta> listaVentas, List<InventarioEntradas> listaEntradas , String codigo) {
		super();
		this.nombre = nombre;
		this.precioUnidad = precioUnidad;
		this.stockDisponible = stockDisponible;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
		Marca = marca;
		CategoriaProducto = categoriaProducto;
		this.listaDetallecompra = listaDetallecompra;
		this.listaVentas = listaVentas;
		this.listaEntradas = listaEntradas;
		this.codigo = codigo;
	}
	
    public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void restarExistencia(Float stockDisponible) {
        this.stockDisponible -= stockDisponible;
    }


	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(Float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getStockDisponible() {
		return stockDisponible;
	}

	public void setStockDisponible(int stockDisponible) {
		this.stockDisponible = stockDisponible;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Marcas getMarca() {
		return Marca;
	}

	public void setMarca(Marcas marca) {
		Marca = marca;
	}

	public CategoriasProductos getCategoriaProducto() {
		return CategoriaProducto;
	}

	public void setCategoriaProducto(CategoriasProductos categoriaProducto) {
		CategoriaProducto = categoriaProducto;
	}

	public List<DetalleCompra> getListaDetallecompra() {
		return listaDetallecompra;
	}

	public void setListaDetallecompra(List<DetalleCompra> listaDetallecompra) {
		this.listaDetallecompra = listaDetallecompra;
	}

	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public List<InventarioEntradas> getListaEntradas() {
		return listaEntradas;
	}

	public void setListaEntradas(List<InventarioEntradas> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}
	 
	 

}
