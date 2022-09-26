package com.sena.disocc.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="proveedores")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="ID_PROVEEDOR")
	private int idProveedor;
	@Column(name="NOMBRE_PROVEEDOR")
	private String nombreProveedor;
	@Column(name="NIT_PROVEEDOR")
	private int nitProveedor;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="TELEFONO")
	private int telefono;
	@Column(name="CORREO")
	private String correo;
	
	@OneToMany(targetEntity = Compra.class, mappedBy = "proveedor")
	private List<Compra> listaCompras;
	
	
}
