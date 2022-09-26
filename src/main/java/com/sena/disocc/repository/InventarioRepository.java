package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Inventarios;

@Repository
public interface InventarioRepository extends JpaRepository<Inventarios, Integer> {

}
