package io.github.danilodantas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilodantas.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {

}
