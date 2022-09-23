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
	
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	public List<Cliente> obterTodos() {
		return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				return new Cliente(id, nome);
			}
		});
	}
}
