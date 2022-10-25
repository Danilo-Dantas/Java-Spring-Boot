package io.github.danilodantas.rest.controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.danilodantas.domain.entity.Produto;
import io.github.danilodantas.domain.repository.Produtos;


import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	private Produtos repository;
	
	public ProdutoController(Produtos repository) {
		this.repository = repository;
	}
	
	//METODO GET
	@GetMapping("{id}")
	public Produto getProdutoById( @PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado"));
	}
	
	//METODO POST
	@PostMapping
	@ResponseStatus(CREATED)
	public Produto save(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	//METODO DELETE
	@DeleteMapping("{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		repository
			.findById(id)
			.map(cliente -> {
				repository.delete(cliente);
				return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}
	
	//METODO ATUALIZAR
	@PutMapping("{id}")
	@ResponseStatus(NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Produto produto) {
		repository.findById(id).map(cliente -> {
			produto.setId(cliente.getId());
			repository.save(produto);
			return cliente;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
	}
	
	//METODO LISTAR TODOS
	@GetMapping
	public List<Produto> find(Produto filtro) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher( 
						ExampleMatcher.StringMatcher.CONTAINING );
		Example<Produto> example = Example.of(filtro, matcher);
		return repository.findAll(example);
	}
}
