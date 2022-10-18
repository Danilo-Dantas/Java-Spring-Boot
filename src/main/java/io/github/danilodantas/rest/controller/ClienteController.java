package io.github.danilodantas.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET)
	@ResponseBody
	public String helloCliente( @PathVariable("nome") String nomeCliente) {
		return String.format("Bem vindo(a), %s! Essa � minha primeira API feita na vida =D", nomeCliente);
	}
	
}
