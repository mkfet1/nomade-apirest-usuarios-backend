package com.hope.usuarios.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hope.usuarios.apirest.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	Usuarios findById(long codigo);
}
