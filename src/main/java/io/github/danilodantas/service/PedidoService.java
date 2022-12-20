package io.github.danilodantas.service;

import java.util.Optional;

import io.github.danilodantas.domain.entity.Pedido;
import io.github.danilodantas.rest.dto.PedidoDTO;

public interface PedidoService {

	Pedido salvar(PedidoDTO dto);
	
	Optional<Pedido> obterPedidoCompleto(Integer id);
}
