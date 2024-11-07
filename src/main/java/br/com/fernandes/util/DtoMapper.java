package br.com.fernandes.util;

import br.com.fernandes.dto.UserCreateDTO;
import br.com.fernandes.entities.User;

public class DtoMapper {

	public static User dtoCreateToEntity(UserCreateDTO userDto) {
		User create = new User();
		create.setNome(userDto.nome());
		create.setEmail(userDto.email());
		create.setSenha(userDto.senha());
		create.setCelular(userDto.celular());
		create.setRole(userDto.role());
		create.setDataNascimento(userDto.dataNascimento());
		
		return create;
	}
}
