package br.com.fernandes.service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernandes.dto.UserPasswordDTO;
import br.com.fernandes.entities.User;
import br.com.fernandes.enums.StatusUser;
import br.com.fernandes.repository.UserRepository;
import br.com.fernandes.service.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;		
	}

	public User createUser(User user) {
		user.setDataCriacao(new Date());
		user.setStatus(StatusUser.Bloqueado);
		
		return userRepository.save(user);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User update(Long id, User user) {
		User findUser = findById(id);
		
		updateUser(findUser, user);
		
		return userRepository.save(findUser);
	}

	private void updateUser(User findUser, User user) {
		findUser.setNome(user.getNome());
		findUser.setCelular(user.getCelular());
		findUser.setDataNascimento(user.getDataNascimento());
		findUser.setEmail(user.getEmail());
		findUser.setRole(user.getRole());
		findUser.setSenha(user.getSenha());		
	}

	public void updatePassword(Long id, UserPasswordDTO userPassword) {
		User findUser = findById(id);
		
		findUser.setSenha(userPassword.novaSenha());
		
		userRepository.save(findUser);		
	}

	public void cancelaUser(Long id) {
		User findUser = findById(id);
		
		findUser.setStatus(StatusUser.Cancelado);
		
		userRepository.save(findUser);
	}
}
