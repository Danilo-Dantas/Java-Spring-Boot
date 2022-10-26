package io.github.danilodantas.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	private Integer cliente;
	private BigDecimal total;
	private List<ItemPedidoDTO> items;
}
