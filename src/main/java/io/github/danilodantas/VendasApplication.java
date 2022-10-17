package io.github.danilodantas;

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
			clientes.save(new Cliente("Isabella"));
			
			//PRINTANDO LISTA DE TODOS OS CLIENTES NO CONSOLE
			System.out.println("LISTANDO CLIENTES SALVOS...");
			
			boolean existe = clientes.existsByNome("Danilo");
			System.out.println("Existe um cliente com o nome Danilo? " + existe);
					
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

