package br.com.fernandes.util;

import br.com.fernandes.dto.UserCreateDTO;
import br.com.fernandes.entities.User;

public class DtoMapper {

	public static User dtoCreateToEntity(UserCreateDTO userDto) {
		User user = new User();
		user.setNome(userDto.nome());
		user.setEmail(userDto.email());
		user.setSenha(userDto.senha());
		user.setCelular(userDto.celular());
		user.setRole(userDto.role());
		user.setDataNascimento(userDto.dataNascimento());
		
		return user;
	}
}
