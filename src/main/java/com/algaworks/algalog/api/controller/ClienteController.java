package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {


	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;
	
	
	@GetMapping("/id/{id}")
	private ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	private List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{nome}")
	private List<Cliente> findByNome(@PathVariable String nome) {
		return clienteRepository.findByNome(nome);
	
	}
	
	@GetMapping("/containing/{nome}")
	private List<Cliente> findByNomeContaining(@PathVariable String nome) {
		return clienteRepository.findByNomeContaining(nome);
	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
	}
	
	
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
											 @Valid @RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
			cliente.setId(clienteId);
			cliente = catalogoClienteService.salvar(cliente);
			return ResponseEntity.ok(cliente);	

		}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		catalogoClienteService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}




