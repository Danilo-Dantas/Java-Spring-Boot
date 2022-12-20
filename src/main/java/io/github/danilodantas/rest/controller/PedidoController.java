package io.github.danilodantas.rest.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.danilodantas.domain.entity.ItemPedido;
import io.github.danilodantas.domain.entity.Pedido;
import io.github.danilodantas.rest.dto.InformacoesItemPedidoDTO;
import io.github.danilodantas.rest.dto.InformacoesPedidoDTO;
import io.github.danilodantas.rest.dto.PedidoDTO;
import io.github.danilodantas.service.PedidoService;

import static org.springframework.http.HttpStatus.*;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@GetMapping("{id}")
	public InformacoesPedidoDTO getById(@PathVariable Integer id) {
		return service
				.obterPedidoCompleto(id)
				.map(p -> converter(p) ).orElseThrow(()-> new ResponseStatusException(NOT_FOUND, "Pedido não encontrado"));
				
	}
	
	private InformacoesPedidoDTO converter(Pedido pedido) {
		return InformacoesPedidoDTO
			.builder()
			.codigo(pedido.getId())
			.dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
			.cpf(pedido.getCliente().getCpf())
			.nomeCliente(pedido.getCliente().getNome())
			.total(pedido.getTotal())
			.status(pedido.getStatus().name())
			.items(converter(pedido.getItens()))
			.build();
	}
	
	private List<InformacoesItemPedidoDTO> converter(List<ItemPedido> itens) {
		if(CollectionUtils.isEmpty(itens)) {
			return Collections.emptyList();
		}
		
		return itens
				.stream()
				.map( 
						item -> InformacoesItemPedidoDTO
						.builder().descricaoProduto(item.getProduto().getDescricao())
						.precoUnitario(item.getProduto().getPreco())
						.quantidade(item.getQuantidade())
						.build()
				).collect(Collectors.toList()); 
	}
	
}
