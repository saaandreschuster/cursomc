package com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Pedido;
import com.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {
	@Autowired
	private PedidoService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
