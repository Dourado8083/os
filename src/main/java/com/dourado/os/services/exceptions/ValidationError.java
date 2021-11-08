package com.dourado.os.services.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.dourado.os.resources.exceptions.StardardError;

public class ValidationError extends StardardError {
	private static final long serialVersionUID = 1L;
	private List<FieldMessage> errors = new ArrayList<>();
	public ValidationError() {
		super();
	}
	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}
	public List<FieldMessage> getErrors() {
		return errors;
	}
	//Mudança de set para add e mudança de List<FieldMessage> errors,instancia novo objeto e add ele n lista 
	public void addErrors(String fieldName,String message) {
		this.errors.add(new FieldMessage( fieldName,message));
	}
	
}
