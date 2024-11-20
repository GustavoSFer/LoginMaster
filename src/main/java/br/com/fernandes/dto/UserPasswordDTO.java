package br.com.fernandes.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserPasswordDTO(
		@NotEmpty(message = "A senha é obrigatória e deve ser informada corretamente no campo 'novaSenha'")
	    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
		String novaSenha
		) {}
