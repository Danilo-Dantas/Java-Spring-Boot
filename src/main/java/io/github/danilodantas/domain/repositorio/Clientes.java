package io.github.danilodantas.domain.repositorio;

import io.github.danilodantas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {
	
	//select c from Cliente c where c.nome like :nome
	List<Cliente> findByNomeLike(String nome);
		
	boolean existsByNome(String nome);
}

