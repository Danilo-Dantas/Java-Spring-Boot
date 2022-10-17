package io.github.danilodantas.domain.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import io.github.danilodantas.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // REPOSITORIO MOSTRA QUE É UMA CLASSE QUE ACESSA BANCO DE DADOS
public class Clientes {

	@Autowired
	private EntityManager entityManager;

	// DELETANDO CLIENTE
	@Transactional
	public void deletar(Cliente cliente) {
		if(!entityManager.contains(cliente)) {
			cliente = entityManager.merge(cliente);
		}
		entityManager.remove(cliente);
	}

	// DELETANDO CLIENTE ID
	@Transactional
	public void deletar(Integer id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		deletar(cliente);
	}

	// PESQUISA CLIENTE POR NOME "LIKE", SEGUNDO JEITO
	@Transactional(readOnly = true)
	public List<Cliente> buscarPorNomeLike(String nome) {
		String jpql = " select c from Cliente c where c.nome like :nome ";
		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	// SALVAR O CLIENTE NA BASE DE DADOS
	@Transactional
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	// ATUALIZAR O CLIENTE
	@Transactional
	public Cliente atualizar(Cliente cliente) {
		entityManager.merge(cliente);
		return cliente;
	}
	
	// LISTAR OS CLIENTES
	@Transactional
	public List<Cliente> obterTodos() {
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}
	
}
