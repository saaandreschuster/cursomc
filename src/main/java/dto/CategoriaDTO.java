package dto;

import java.io.Serializable;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Size(min = 5, max=80, message = "O tamanho deve ser entre que 5 e 80 caracteres.")
	private String nome;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
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

}
