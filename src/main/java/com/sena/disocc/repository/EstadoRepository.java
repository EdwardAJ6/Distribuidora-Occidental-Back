package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
