package com.sena.disocc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.disocc.modelo.Rol;
import com.sena.disocc.modelo.TipoDocumento;
import com.sena.disocc.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query ("SELECT u FROM Usuario u WHERE u.email = ?1")
	public Usuario findByEmail(String email);
	
	public List<Usuario> findByTipoDocumento(TipoDocumento tipoDocumento);
	
}


