package com.casadocodigo.dto;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AutorResponse {

	private String nome;	
	private String email;
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}


	

}
