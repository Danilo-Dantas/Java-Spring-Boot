package io.github.danilodantas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danilodantas.model.Cliente;
import io.github.danilodantas.repository.ClientesRepository;

@Service
public class ClientesService {

	private ClientesRepository repository; 
	
	@Autowired
	public ClientesService( ClientesRepository repository) {
		this.repository = repository;
	}
	
	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		ClientesRepository clientesRepository = new ClientesRepository();
		clientesRepository.persistir(cliente);
	}
	
	public void validarCliente(Cliente cliente) {
		//aplicar validação
	}
}
