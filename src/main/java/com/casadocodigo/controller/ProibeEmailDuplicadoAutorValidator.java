package com.casadocodigo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.dto.AutorRequest;
import com.casadocodigo.model.Autor;
import com.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
	
	@Autowired
	private AutorRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(errors.hasErrors()) {
			return;
		}
		
		AutorRequest request = (AutorRequest) target;
		Optional<Autor> possivelAutor = repository.findByEmail(request.getEmail());
		 if(possivelAutor.isPresent()) {
			 errors.rejectValue("email",null, "Já existe autor com mesmo email");
		 }
		
	}

}
