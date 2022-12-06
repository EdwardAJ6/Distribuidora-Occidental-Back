package com.sena.disocc.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private int idRol;
	@Column(name = "NOM_ROL")
	private String nomRol;
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNomRol() {
		return nomRol;
	}
	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rol(int idRol, String nomRol) {
		super();
		this.idRol = idRol;
		this.nomRol = nomRol;
	}
	public Rol(String nomRol) {
		super();
		this.nomRol = nomRol;
	}
	@Override
	public String toString() {
		return this.nomRol;
	}
	
	
	


}
