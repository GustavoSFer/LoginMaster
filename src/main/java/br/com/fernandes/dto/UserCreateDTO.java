package br.com.fernandes.dto;

import java.util.Date;

import br.com.fernandes.enums.RoleUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Com record, o Java cria automaticamente todos os métodos básicos para você,
 * como os "getters" (para acessar os valores dos campos), o toString (para imprimir os valores) 
 * e até equals e hashCode (para comparar objetos). Assim, se você só precisa de uma classe para
 *  guardar dados e não quer escrever tudo isso, o record faz esse trabalho por você.
 */

public record UserCreateDTO(
		@NotEmpty(message = "O nome não pode estar vazio!")
	    @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres.")
	    String nome,

	    @NotEmpty(message = "O e-mail não pode estar vazio!")
	    @Email(message = "Formato do e-mail inválido!")
	    String email,

	    @NotEmpty(message = "A senha não pode estar vazia!")
	    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
	    String senha,

	    @NotNull(message = "O numero de celular não pode estar vazio!")
	    @Pattern(regexp = "\\d{11}", message = "O numero de celular deve conter 11 caracteres numéricos.")
	    String celular,

	    @NotNull(message = "Informe se o usuário é ADMINISTRADOR ou USUARIO.")
	    RoleUser role,

	    @NotNull(message = "A data de nascimento deve ser informada!")
	    @Past(message = "A data de nascimento deve ser uma data no passado.")
	    Date dataNascimento
	    ) {}
