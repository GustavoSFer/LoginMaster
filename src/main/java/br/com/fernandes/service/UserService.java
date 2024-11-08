package br.com.fernandes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernandes.entities.User;
import br.com.fernandes.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;		
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

}
