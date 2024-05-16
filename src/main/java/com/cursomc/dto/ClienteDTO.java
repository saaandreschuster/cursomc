package com.cursomc.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.cursomc.domain.Cliente;
import com.cursomc.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório do nome.")
	@Size(min = 5, max=120, message = "O tamanho deve ser entre que 5 e 80 caracteres.")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório do E-mail.")
	@Email(message = "E-mail inválido.")
	private String email;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
