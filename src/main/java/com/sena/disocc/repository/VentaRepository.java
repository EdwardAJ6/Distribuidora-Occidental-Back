package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
