package com.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Pedido;
import com.domain.Pedido;
import com.services.PedidoService;

import dto.PedidoDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {
	@Autowired
	private PedidoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido objDto) {
		// Pedido obj = service.fromDTO(objDto);
		Pedido obj = objDto;
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
