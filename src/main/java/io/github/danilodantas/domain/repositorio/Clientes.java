package io.github.danilodantas.domain.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import io.github.danilodantas.domain.entity.Cliente;

@Repository //REPOSITORIO MOSTRA QUE É UMA CLASSE QUE ACESSA BANCO DE DADOS
public class Clientes {

	private static String INSERT = "insert into cliente (nome) values (?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
}
