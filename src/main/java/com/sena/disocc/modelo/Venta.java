package com.sena.disocc.modelo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sena.disocc.utilitis.Utiles;

import lombok.Data;

@Entity
@Table(name ="ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENTA")
	private int idVenta;
	
	@Column(name = "FECHA")
	private String fecha;
	
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
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<ProductoVendido> productosVendidos;

	public Venta(
            
		    ) {
		        this.fecha = Utiles.obtenerFechaYHoraActual();
		    }
	
	public Float getTotal() {
        Float total = 0f;
        for (ProductoVendido productoVendido : this.productosVendidos) {
            total += productoVendido.getTotal();
        }
        return total;
    }

	public Venta(int idVenta, String fecha, long total, String pago_realizado, Usuario usuario, Productos producto,
			List<DetalleVenta> listaDetalleVentas, Set<ProductoVendido> productosVendidos) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.total = total;
		this.pago_realizado = pago_realizado;
		this.usuario = usuario;
		this.producto = producto;
		this.listaDetalleVentas = listaDetalleVentas;
		this.productosVendidos = productosVendidos;
	}
	
	

	public void setTotal(long total) {
		this.total = total;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPago_realizado() {
		return pago_realizado;
	}

	public void setPago_realizado(String pago_realizado) {
		this.pago_realizado = pago_realizado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public List<DetalleVenta> getListaDetalleVentas() {
		return listaDetalleVentas;
	}

	public void setListaDetalleVentas(List<DetalleVenta> listaDetalleVentas) {
		this.listaDetalleVentas = listaDetalleVentas;
	}

	public Set<ProductoVendido> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(Set<ProductoVendido> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	
	
}
