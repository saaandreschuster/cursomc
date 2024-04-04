package com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Estado;
import com.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResources {
	@Autowired
	private EstadoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Estado> find(@PathVariable Integer id) {
		Estado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
