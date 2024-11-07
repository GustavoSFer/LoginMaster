package br.com.fernandes.dto;

import java.util.Date;

/**
 * Com record, o Java cria automaticamente todos os métodos básicos para você,
 * como os "getters" (para acessar os valores dos campos), o toString (para imprimir os valores) 
 * e até equals e hashCode (para comparar objetos). Assim, se você só precisa de uma classe para
 *  guardar dados e não quer escrever tudo isso, o record faz esse trabalho por você.
 */

public record UserCreateDTO(String nome, String email, String senha, String celular, String role, Date dataNascimento) {}
