package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Peticion;

@Repository
public interface PeticionRepository extends JpaRepository<Peticion, Integer>{

}
