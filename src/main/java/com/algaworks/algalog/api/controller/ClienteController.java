package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	
	@GetMapping("/clientes")
	private List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Maria Joana da Silva");
		cliente1.setEmail("maria@gmail.com");
		cliente1.setTelefone("71925338844");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Carlos Jose dos Santos");
		cliente2.setEmail("carlos@gmail.com");
		cliente2.setTelefone("71988226633");
		
		return Arrays.asList(cliente1, cliente2);
	}
	
}
