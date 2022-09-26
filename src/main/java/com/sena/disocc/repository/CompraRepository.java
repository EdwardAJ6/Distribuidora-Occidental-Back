package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
