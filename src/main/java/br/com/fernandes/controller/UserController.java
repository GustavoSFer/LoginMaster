package br.com.fernandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernandes.dto.UserCreateDTO;
import br.com.fernandes.entities.User;
import br.com.fernandes.service.UserService;
import br.com.fernandes.util.DtoMapper;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserCreateDTO UserCreateDTO) {
		User user = DtoMapper.dtoCreateToEntity(UserCreateDTO);
		User create = userService.createUser(user);
		
		return ResponseEntity.ok().body(create);
	}

}
