package br.com.fernandes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


import br.com.fernandes.entities.User;
import br.com.fernandes.enums.RoleUser;
import br.com.fernandes.repository.UserRepository;
import br.com.fernandes.service.UserService;

@SpringBootTest
public class LoginServiceTest {
	
	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	@DisplayName("Cadastrar um user na base de dados")
	public void testCreateUser() throws ParseException {
		// 1ª - Ter acesso a camada de serviço (UserService userService)
		// 2ª - Deixar o mock para simular o banco (UserRepository userRepository)
		// 3ª - Realizar o teste da criação do user criando um user e colocando no mockito
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = sdf.parse("03/04/1992");
		
		User mockUser = new User("Gustavo Fernandes", "gustavo@gmail.com", "256$%Gu", "11969122212", RoleUser.USUARIO, dataNascimento);
		
		Mockito.when(userRepository.save(any(User.class))).thenReturn(mockUser);
		
		User userCreate = userService.createUser(mockUser);
		
		assertEquals("Gustavo Fernandes", userCreate.getNome());
		
	}

}
