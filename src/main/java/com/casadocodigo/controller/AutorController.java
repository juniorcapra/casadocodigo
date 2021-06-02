package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.dto.AutorRequest;
import com.casadocodigo.model.Autor;

@RestController
@RequestMapping(path = "/v1/autor", produces = "application/hal+json;charset=utf8")
public class AutorController {
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
		
	}
	
	@PersistenceContext
	private EntityManager em;

	@PostMapping()
	@Transactional
	public ResponseEntity autor(@Valid @RequestBody AutorRequest response) {
		Autor autor = new Autor();
		autor.setEmail(response.getEmail());
		autor.setNome(response.getNome());
		em.persist(autor);
		
		return ResponseEntity.ok(response);
		
	}

}
