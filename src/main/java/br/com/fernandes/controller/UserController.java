package br.com.fernandes.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernandes.dto.UserCreateDTO;
import br.com.fernandes.dto.UserDTO;
import br.com.fernandes.dto.UserPasswordDTO;
import br.com.fernandes.entities.User;
import br.com.fernandes.service.UserService;
import br.com.fernandes.util.DtoMapper;
import br.com.fernandes.util.UserMapperDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateDTO UserCreateDTO) {
		User user = DtoMapper.dtoCreateToEntity(UserCreateDTO);
		User create = userService.createUser(user);
		
		return ResponseEntity.ok().body(create);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = userService.findAll();
		
		//List<UserDTO> userDTO = users.stream().map(x -> UserMapperDTO.userToUserDTO(x)).collect(Collectors.toList());
		List<UserDTO> userDTO = users.stream().map(UserMapperDTO::userToUserDTO).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(userDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserCreateDTO UserCreateDTO) {
		User user = DtoMapper.dtoCreateToEntity(UserCreateDTO);
		
		User userUpdate = userService.update(id, user);
		
		return ResponseEntity.ok().body(UserMapperDTO.userToUserDTO(userUpdate));
	}
	
	@PatchMapping(value = "/{id}/password")
	public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody UserPasswordDTO userPassword) {
		
		userService.updatePassword(id, userPassword);
		
		return ResponseEntity.ok("Senha alterada com sucesso!");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> cancelaUser(@PathVariable Long id) {
		userService.cancelaUser(id);
		
		return ResponseEntity.ok("Usuário cancelado com sucesso!");
	}

}
