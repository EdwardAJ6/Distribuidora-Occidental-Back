package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

	
    Productos findFirstByCodigo(String codigo);

}
