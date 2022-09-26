package com.sena.disocc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer>{

}
