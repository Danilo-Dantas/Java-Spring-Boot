package io.github.danilodantas.service.impl;

import org.springframework.stereotype.Service;

import io.github.danilodantas.domain.repository.Pedidos;
import io.github.danilodantas.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	private Pedidos repository;
	
	public PedidoServiceImpl(Pedidos repository) {
		this.repository = repository;
	}
}
