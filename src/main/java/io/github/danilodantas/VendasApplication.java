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
			clientes.save(new Cliente("Danilo"));
			clientes.save(new Cliente("Marcos"));
			clientes.save(new Cliente("Felipe"));
			clientes.save(new Cliente("Robson"));
			clientes.save(new Cliente("Wesley"));
			clientes.save(new Cliente("Juan Danilo"));
			clientes.save(new Cliente("Outro Cliente"));
			
			//PRINTANDO LISTA DE TODOS OS CLIENTES NO CONSOLE
			System.out.println("LISTANDO CLIENTES SALVOS...");
			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);
			
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " - atualizado.");
				clientes.save(c);
			});
			
			//ATUALIZAR CLIENTES
			System.out.println("ATUALIZANDO...");
			clientes.save(new Cliente(1,"Douglas"));
			
			//DELETAR CLIENTE
			System.out.println("DELETANDO..." + clientes.findByNomeLike("Robson"));
			clientes.delete(new Cliente(4));
			
			//BUSCANDO POR NOME ESPECIFICO
			System.out.println("BUSCANDO POR NOME...");
			String nome = "Wesley";
			if(clientes.findByNomeLike(nome).isEmpty()) {
				System.out.println("Nome não encontrado.");
			} else {
				clientes.findByNomeLike(nome).forEach(System.out::println);
			}

			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

