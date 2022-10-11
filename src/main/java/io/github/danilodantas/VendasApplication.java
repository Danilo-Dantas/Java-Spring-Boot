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
			System.out.println("SALVANDO...");
			clientes.salvar(new Cliente("Danilo"));
			clientes.salvar(new Cliente("Marcos"));
			clientes.salvar(new Cliente("Felipe"));
			clientes.salvar(new Cliente("Robson"));
			clientes.salvar(new Cliente("Wesley"));
			clientes.salvar(new Cliente("Juan Danilo"));
			clientes.salvar(new Cliente("Outro Cliente"));
			
			//PRINTANDO LISTA DE TODOS OS CLIENTES NO CONSOLE
			System.out.println("LISTANDO CLIENTES SALVOS...");
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			todosClientes.forEach(cadaCliente -> {
				cadaCliente.setNome(cadaCliente.getNome() + " - atualizado.");
				clientes.atualizar(cadaCliente);
			});
			
			//ATUALIZAR CLIENTES
			System.out.println("ATUALIZANDO...");
			clientes.atualizar(new Cliente(1,"Douglas"));
			
			//DELETAR CLIENTE
			System.out.println("DELETANDO..." + clientes.buscarClienteId(4));
			clientes.deletar(new Cliente(4));
			
			//BUSCANDO POR NOME ESPECIFICO
			System.out.println("BUSCANDO POR NOME...");
			String nome = "Wesley";
			if(clientes.buscarPorNomeLike(nome).isEmpty()) {
				System.out.println("Nome não encontrado.");
			} else {
				clientes.buscarPorNomeLike(nome).forEach(System.out::println);
			}

//			todosClientes = clientes.obterTodos();
//			todosClientes.forEach(System.out::println);
			
			//BUSCAR POR NOME "STRING NOME"
			//List<Cliente> listaPorNome = clientes.buscarPorNome("Felipe");
			//listaPorNome.forEach(System.out::println);		
			
			//BUSCANDO POR NOME E ID "OBJETO CLIENTE"
			//List<Cliente> listaPorNomeId = clientes.buscarPorNomeId(new Cliente(2,"Marcos"));
			//listaPorNomeId.forEach(System.out::println);
			
			//BUSCANDO POR NOME LIKE
			//List<Cliente> listaPorNomeLike = clientes.buscarPorNomeLike("Danilo");
			//listaPorNomeLike.forEach(System.out::println);		
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

