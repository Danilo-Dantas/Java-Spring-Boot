package io.github.danilodantas.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.github.danilodantas.validation.NotEmptyList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	@NotNull(message = "Informe o c�digo do cliente.")
    private Integer cliente;
	
	@NotNull(message = "Campo Total do pedido � obrigat�rio.")
    private BigDecimal total;
	@NotEmptyList(message = "Pedido n�o pode ser realizado sem itens.")
    private List<ItemPedidoDTO> items;
}
