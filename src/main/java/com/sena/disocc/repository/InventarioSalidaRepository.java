package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.InventarioSalidas;

@Repository
public interface InventarioSalidaRepository extends JpaRepository<InventarioSalidas, Integer> {

}
