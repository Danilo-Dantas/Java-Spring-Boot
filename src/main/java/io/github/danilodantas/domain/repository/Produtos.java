package io.github.danilodantas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilodantas.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
