package com.services.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domain.enums.TipoCliente;
import com.resources.exception.FieldMessage;
import com.services.validation.utils.BR;

import dto.ClienteNewDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {

	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os teste aqui, inserindo erros na lista
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
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
