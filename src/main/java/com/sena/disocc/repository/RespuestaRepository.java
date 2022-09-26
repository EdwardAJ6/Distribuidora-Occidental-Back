package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer>{

}
