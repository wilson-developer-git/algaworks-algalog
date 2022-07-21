package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	private List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{nome}")
	private List<Cliente> findByNome(@PathVariable String nome) {
		return clienteRepository.findByNome(nome);
	
	}
	
	@GetMapping("/clientes/containing/{nome}")
	private List<Cliente> findByNomeContaining(@PathVariable String nome) {
		return clienteRepository.findByNomeContaining(nome);
	
	}
	
}
