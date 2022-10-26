package io.github.danilodantas.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "cliente") //NOME DA TABELA
public class Cliente { 
	
	//********************** COLUNAS DA TABELA **********************************
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@JsonIgnore
	@OneToMany( mappedBy = "cliente" , fetch = FetchType.EAGER)
	private Set<Pedido> pedidos;
	//***************************************************************************
	
	public Cliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
}
