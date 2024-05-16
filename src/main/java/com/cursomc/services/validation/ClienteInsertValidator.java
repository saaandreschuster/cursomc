package com.cursomc.services.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cursomc.domain.Cliente;
import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.resources.exception.FieldMessage;
import com.cursomc.services.validation.utils.BR;

import com.cursomc.dto.ClienteNewDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClienteInsert ann) {

	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os teste aqui, inserindo erros na lista
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido."));
		}
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido."));
		}

		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "E-Mail já existe."));
		}

		for (Iterator<FieldMessage> iterator = list.iterator(); iterator.hasNext();) {
			FieldMessage fieldMessage = (FieldMessage) iterator.next();
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fieldMessage.getMessage())
					.addPropertyNode(fieldMessage.getFieldNmae()).addConstraintViolation();

		}
		return list.isEmpty();
	}
}
