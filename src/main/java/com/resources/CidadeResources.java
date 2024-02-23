package com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Cidade;
import com.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResources {
	@Autowired
	private CidadeService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
