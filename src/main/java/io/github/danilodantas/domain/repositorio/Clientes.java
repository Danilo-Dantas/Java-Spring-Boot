package io.github.danilodantas.domain.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import io.github.danilodantas.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository //REPOSITORIO MOSTRA QUE É UMA CLASSE QUE ACESSA BANCO DE DADOS
public class Clientes {

	private static String INSERT = "insert into cliente (nome) values (?)";
	private static String SELECT_ALL = "SELECT * FROM CLIENTE";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SALVAR O CLIENTE NA BASE DE DADOS
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	//LISTAR OS CLIENTES
	public List<Cliente> obterTodos() {
		return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
				Integer id = resultSet.getInt("id"); //PEGANDO O RESULTADO DA PESQUISA FEITA NO BANCO PARA A COLUNA "ID"
				String nome = resultSet.getString("nome"); //PEGANDO O RESULTADO DA PESQUISA FEITA NO BANCO PARA A COLUNA "NOME"
				return new Cliente(id, nome);
			}
		});
	}
}

