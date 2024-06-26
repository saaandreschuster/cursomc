package com.cursomc.dto;

import java.io.Serializable;

import com.cursomc.services.validation.ClienteInsert;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@ClienteInsert
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Size(min = 5, max = 120, message = "O tamanho deve ser entre que 5 e 80 caracteres.")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "E-mail inválido.")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String cpfOuCnpj;

	private Integer tipo;

	@NotEmpty(message = "Preenchimento obrigatório.")
	private String logradouro;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String telefone1;
	private String telefone2;
	private String telefone3;

	private Integer cidadeId;

	public ClienteNewDTO() {
		super();
	}

	public ClienteNewDTO(Integer id, String nome, String email, String cpfOuCnpj, Integer tipo, String logradouro,
			String numero, String complemento, String bairro, String cep, String telefone1, String telefone2,
			String telefone3, Integer cidadeId) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.cidadeId = cidadeId;
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

}
