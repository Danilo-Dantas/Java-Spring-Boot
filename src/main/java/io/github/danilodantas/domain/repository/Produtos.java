package io.github.danilodantas.domain.repository;

import io.github.danilodantas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
