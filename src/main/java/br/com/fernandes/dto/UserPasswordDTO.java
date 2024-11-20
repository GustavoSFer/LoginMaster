package br.com.fernandes.dto;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserPasswordDTO(
		@NotEmpty(message = "A senha não pode estar vazia!")
	    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
		String novaSenha
		) {}
