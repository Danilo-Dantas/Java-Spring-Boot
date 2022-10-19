package io.github.danilodantas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.danilodantas.domain.entity.Cliente;
import io.github.danilodantas.domain.repository.Clientes;

@SpringBootApplication
public class VendasApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes) {
		return args -> {
			Cliente c = new Cliente(null, "Fulano");
			clientes.save(c);
			
			System.out.println(c);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

