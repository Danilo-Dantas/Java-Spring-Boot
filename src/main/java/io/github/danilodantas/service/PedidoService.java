package io.github.danilodantas.service;

import io.github.danilodantas.domain.entity.Pedido;
import io.github.danilodantas.domain.enums.StatusPedido;
import io.github.danilodantas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
