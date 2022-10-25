package io.github.danilodantas.domain.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	//CONTRUTORES
	public Cliente() {
		
	}
	
	public Cliente(Integer id) {
		this.id = id;
	}
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public Cliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	//GETTERS E SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//METODO QUE VAI FORMATAR O TEXTO QUE SERA EXECUTADO NO CONSOLE COM O RESULTADO DO BANCO
	@Override
	public String toString() {
		return "Cliente{ " + "id=" + id + ", nome='" + nome + '\'' +	'}';
	}
}
