package io.github.danilodantas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilodantas.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

}
