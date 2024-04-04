package com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Endereco;
import com.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResources {
	@Autowired
	private EnderecoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> find(@PathVariable Integer id) {
		Endereco obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
