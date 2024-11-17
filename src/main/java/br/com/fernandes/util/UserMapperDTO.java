package br.com.fernandes.util;

import br.com.fernandes.dto.UserDTO;
import br.com.fernandes.entities.User;

public class UserMapperDTO {
	
	public static UserDTO userToUserDTO (User user) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(user.getId());
		userDTO.setCelular(user.getCelular());
		userDTO.setDataCriacao(user.getDataCriacao());
		userDTO.setDataNascimento(user.getDataNascimento());
		userDTO.setEmail(user.getEmail());
		userDTO.setNome(user.getNome());
		userDTO.setRole(user.getRole());
		userDTO.setStatus(user.getStatus());
		userDTO.setVerificado(user.isVerificado());
		
		return userDTO;
		
	}

}
