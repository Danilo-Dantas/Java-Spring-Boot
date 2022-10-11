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

	private static String INSERT = "insert into cliente (nome) values (?) ";
	private static String SELECT_POR_NOME = "select * from cliente where nome = ? ";
	private static String SELECT_POR_NOME_ID = "select * from cliente where nome = ? and id = ? ";
	private static String SELECT_ALL = "select * from cliente ";
	private static String UPDATE = "update cliente set nome = ? where id = ? ";
	private static String DELETE = "delete from cliente where id = ? ";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//DELETANDO CLIENTE
	public Cliente deletar(Cliente cliente) {
		jdbcTemplate.update(DELETE, new Object[] {cliente.getId()});
		return cliente;
	}
	
	//PESQUISA CLIENTE POR NOME "STRING NOME"
	public List<Cliente> buscarPorNome(String nome) {
		return jdbcTemplate.query(
				SELECT_POR_NOME, 
				new Object[] {nome},
				obterClienteMapper());
	}
	
	//PESQUISA CLIENTE POR ID "INTEGER ID"
	public List<Cliente> buscarClienteId(Integer id) {
		return jdbcTemplate.query(
				SELECT_ALL.concat("where id = ?"),
				new Object[] {id},
				obterClienteMapper());		
	}
	
	//PESQUISA CLIENTE POR NOME "OBJETO CLIENTE"
		public List<Cliente> buscarPorNomeId(Cliente cliente) {
			return jdbcTemplate.query(
					SELECT_POR_NOME_ID, 
					new Object[] {cliente.getNome(), cliente.getId()},
					obterClienteMapper());
		}
	
	//PESQUISA CLIENTE POR NOME "LIKE", SEGUNDO JEITO
		public List<Cliente> buscarPorNomeLike(String nome) {
			return jdbcTemplate.query(
					SELECT_ALL.concat(" where nome like ? "),
					new Object[] {"%" + nome + "%"},
					obterClienteMapper());
	}
	
	//SALVAR O CLIENTE NA BASE DE DADOS
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	//ATUALIZAR O CLIENTE
	public Cliente atualizar(Cliente cliente) {
		jdbcTemplate.update(UPDATE, new Object[] {cliente.getNome(), cliente.getId()});
		return cliente;
	}
	
	//LISTAR OS CLIENTES
	public List<Cliente> obterTodos() {
		return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
	}

	private RowMapper<Cliente> obterClienteMapper() {
		return new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
				Integer id = resultSet.getInt("id"); //PEGANDO O RESULTADO DA PESQUISA FEITA NO BANCO PARA A COLUNA "ID"
				String nome = resultSet.getString("nome"); //PEGANDO O RESULTADO DA PESQUISA FEITA NO BANCO PARA A COLUNA "NOME"
				return new Cliente(id, nome);
			}
		};
	}
}

