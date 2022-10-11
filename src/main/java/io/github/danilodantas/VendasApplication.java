package io.github.danilodantas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.danilodantas.domain.entity.Cliente;
import io.github.danilodantas.domain.repositorio.Clientes;

@SpringBootApplication
public class VendasApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			//SALVANDO CLIENTES
			clientes.salvar(new Cliente("Danilo"));
			clientes.salvar(new Cliente("Marcos"));
			clientes.salvar(new Cliente("Felipe"));
			clientes.salvar(new Cliente("Robson"));
			clientes.salvar(new Cliente("Wesley"));
			clientes.salvar(new Cliente("Juan Danilo"));
			clientes.salvar(new Cliente("Outro Cliente"));
			
			//ATUALIZAR CLIENTES
			clientes.atualizar(new Cliente(2,"Douglas"));
			
			//DELETAR CLIENTE
			clientes.deletar(new Cliente(1));
			
			//BUSCAR POR NOME "STRING NOME"
			List<Cliente> listaPorNome = clientes.buscarPorNome("Felipe");
			listaPorNome.forEach(System.out::println);		
			
			//BUSCANDO POR NOME E ID "OBJETO CLIENTE"
			List<Cliente> listaPorNomeId = clientes.buscarPorNomeId(new Cliente(2,"Marcos"));
			listaPorNomeId.forEach(System.out::println);
			
			//BUSCANDO POR NOME LIKE
			//List<Cliente> listaPorNomeLike = clientes.buscarPorNomeLike("Danilo");
			//listaPorNomeLike.forEach(System.out::println);
			
			//PRINTANDO LISTA DE CLIENTES NO CONSOLE
			//List<Cliente> todosClientes = clientes.obterTodos();
			//todosClientes.forEach(System.out::println);
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

