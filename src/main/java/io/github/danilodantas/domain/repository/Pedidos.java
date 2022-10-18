package io.github.danilodantas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilodantas.domain.entity.Cliente;
import io.github.danilodantas.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByCliente( Cliente cliente );
	
}
