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
@Table(name="categorias_productos")
public class CategoriasProductos {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIA")
	private int idCategoria;
	
	@Column(name="NOMBRE_CATEGORIA")
	private String idNombreCategoria;
	
	@OneToMany(targetEntity = Productos.class, mappedBy = "CategoriaProducto")
	private List<Productos> listaProductos;
}
