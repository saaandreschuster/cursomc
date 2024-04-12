package com.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldNmae;
	private String message;

	public FieldMessage() {
		super();
	}

	public FieldMessage(String fieldNmae, String message) {
		super();
		this.fieldNmae = fieldNmae;
		this.message = message;
	}

	public String getFieldNmae() {
		return fieldNmae;
	}

	public void setFieldNmae(String fieldNmae) {
		this.fieldNmae = fieldNmae;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
