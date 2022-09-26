package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.CategoriasProductos;

@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriasProductos, Integer> {

}
