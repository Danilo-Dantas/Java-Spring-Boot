package io.github.danilodantas.domain.entity;

public class Cliente {

	private Integer id;
	private String nome;

	//CONTRUTORES
	public Cliente() {
		
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
		return "Cliente{" + 
				"id=" + id + 
				", nome='" + nome + '\'' +
				'}';
		
	}
}
