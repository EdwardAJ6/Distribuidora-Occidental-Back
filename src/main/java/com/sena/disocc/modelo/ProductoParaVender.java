package com.sena.disocc.modelo;

import java.util.Date;
import java.util.List;

public class ProductoParaVender extends Productos{
	
	private float cantidad;
	
	public ProductoParaVender(int idProducto, String nombre, Float precioUnidad,int stockDisponible, String descripcion, 
			Date fechaVencimiento,Marcas Marca,CategoriasProductos CategoriaProducto,
			List<DetalleCompra> listaDetallecompra, List<Venta> listaVentas, List<InventarioEntradas> listaEntradas, String codigo,float cantidad) {
		super(idProducto,nombre,precioUnidad,stockDisponible,descripcion,fechaVencimiento,Marca,CategoriaProducto, listaDetallecompra, listaVentas, listaEntradas, codigo);
		this.cantidad=cantidad;
	}
	
	public ProductoParaVender(String nombre, Float precioUnidad, int stockDisponible, String descripcion, Date fechaVencimiento,
			Marcas marca, CategoriasProductos categoriaProducto, List<DetalleCompra> listaDetallecompra,
			List<Venta> listaVentas, List<InventarioEntradas> listaEntradas, float cantidad, String codigo) {
	super(nombre,precioUnidad,stockDisponible,descripcion,fechaVencimiento,marca,categoriaProducto, listaDetallecompra, listaVentas, listaEntradas, codigo);
		this.cantidad=cantidad;
	}
	
	public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public Float getTotal() {
        return this.getPrecioUnidad() * this.cantidad;
    }
	
	
	
	
	

}
