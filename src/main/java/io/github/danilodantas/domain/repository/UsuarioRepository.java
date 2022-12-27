package io.github.danilodantas.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilodantas.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
	Optional<Usuario> findByLogin(String login);
}
