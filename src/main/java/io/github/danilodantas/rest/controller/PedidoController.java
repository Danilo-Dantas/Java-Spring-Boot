package io.github.danilodantas.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.danilodantas.domain.entity.Pedido;
import io.github.danilodantas.rest.dto.PedidoDTO;
import io.github.danilodantas.service.PedidoService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	private PedidoService service;

	public PedidoController(PedidoService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Integer save(@RequestBody PedidoDTO dto) {
		Pedido pedido = service.salvar(dto);
		return pedido.getId();
	}
	
	public void testarDevTools() {
		
	}
}
