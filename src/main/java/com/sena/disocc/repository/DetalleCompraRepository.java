package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.DetalleCompra;

@Repository
public interface DetalleCompraRepository extends JpaRepository <DetalleCompra, Integer>{

}
