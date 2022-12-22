package io.github.danilodantas.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	@NotNull(message = "Informe o código do cliente.")
    private Integer cliente;
	
	@NotNull(message = "Campo Total do pedido é obrigatório.")
    private BigDecimal total;
	
    private List<ItemPedidoDTO> items;
}
