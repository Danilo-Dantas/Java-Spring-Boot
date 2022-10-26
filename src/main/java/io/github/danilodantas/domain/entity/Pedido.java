package io.github.danilodantas.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

	//******************** COLUNAS DA TABELA *************************
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente; //FOREIGN KEY (CLIENTE)
	
	@Column(name = "data_pedido")
	private LocalDate dataPedido;
	
	@Column(name = "total", precision = 20 ,scale = 2) //PRECISION: QTD DE DIGITOS QUE TEM / SCALE: QTD DE DECIMAIS
	private BigDecimal total;
	
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;
	//****************************************************************
	
	public List<ItemPedido> getItens() {
		if(this.itens == null) {
			this.itens = new ArrayList<>();
		}
		return this.itens;
	}
}
