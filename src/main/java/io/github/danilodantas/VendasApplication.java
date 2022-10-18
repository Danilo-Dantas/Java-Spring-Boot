package io.github.danilodantas;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.github.danilodantas.domain.entity.Cliente;
import io.github.danilodantas.domain.entity.Pedido;
import io.github.danilodantas.domain.repository.Clientes;
import io.github.danilodantas.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {
	
	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes, 
			@Autowired Pedidos pedidos) {
		return args -> {
			//SALVANDO CLIENTES
			System.out.println("SALVANDO...");
			Cliente fulano = new Cliente("Fulano");
			clientes.save(fulano);
			
			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(20));
			
			pedidos.save(p);
			
			Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
			System.out.println(cliente);
			System.out.println(cliente.getPedidos());
					
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

