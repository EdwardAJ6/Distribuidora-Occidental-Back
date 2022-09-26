package com.sena.disocc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="permisos")
public class Permiso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERMISO")
	private int idPermiso;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Permiso(int idPermiso, String descripcion) {
		super();
		this.idPermiso = idPermiso;
		this.descripcion = descripcion;
	}

	public Permiso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
