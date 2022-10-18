package io.github.danilodantas.domain.entity;

import java.util.Set;

import javax.persistence.*;

@Entity //INDICA AO JPA QUE FAÇA O SCAN DESSA CLASSE(CLIENTE) E REGISTRE ELA COMO UMA TABELA DO BANCO DE DADOS
@Table(name = "cliente")
public class Cliente { //CLASSE DE ENTIDADE REFERENTE A TABELA CLIENTE DO BANCO DE DADOS
	
	@Id //IDENTIFICA A PRIMARY KEY DA TABELA
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")//CASO O NOME DA COLUNA ID SEJA DIFERENTE, PODEMOS USAR ESSA ANNOTATION, NESSE CASO É MEIO INUTIL, MAS COLOQUEI DE EXEMPLO
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@OneToMany( mappedBy = "cliente" , fetch = FetchType.EAGER)
	private Set<Pedido> pedidos;

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
	
	//METODO QUE VAI FORMATAR O TEXTO QUE SERA EXECUTADO NO CONSOLE COM O RESULTADO DO BANCO
	@Override
	public String toString() {
		return "Cliente{ " + "id=" + id + ", nome='" + nome + '\'' +	'}';
		
	}
}
