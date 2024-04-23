package com.services.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.domain.Cliente;
import com.repositories.ClienteRepository;
import com.resources.exception.FieldMessage;

import dto.ClienteDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteInsert, ClienteDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClienteInsert ann) {

	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		Map<String, String> map = ((Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
		Integer uriId = Integer.parseInt(map.get("id"));
		// inclua os teste aqui, inserindo erros na lista
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
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
