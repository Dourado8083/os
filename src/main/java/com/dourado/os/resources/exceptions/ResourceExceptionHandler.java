package com.dourado.os.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dourado.os.services.exceptions.DataIntegratyViolationException;
import com.dourado.os.services.exceptions.ObjectNotFoundException;
import com.dourado.os.services.exceptions.ValidationError;

//Manipulador de exceção da camada de recurso
@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StardardError> objectNotFoundException(ObjectNotFoundException e) {
		StardardError error = new StardardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StardardError> DataIntegratyViolationExceptionn(DataIntegratyViolationException e) {
		StardardError error = new StardardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	//Manipulando a exceção de vazio
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StardardError> objectNotFoundException(MethodArgumentNotValidException e) {
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos!");
	    //Percorrer a lista 
		for(FieldError x: e.getBindingResult().getFieldErrors()) {
			error.addErrors(x.getField(),x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
