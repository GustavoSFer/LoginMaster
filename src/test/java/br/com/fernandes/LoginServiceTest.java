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
		
		// Configurar o formato de data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = sdf.parse("03/04/1992");
		
		// Criar o mock do usuário
		User mockUser = new User("Gustavo Fernandes", "gustavo@gmail.com", "256$%Gu", "11969122212", RoleUser.USUARIO, dataNascimento);
		
		// Simular o comportamento do repositório
		Mockito.when(userRepository.save(any(User.class))).thenReturn(mockUser);
		
		// Chamar o método de serviço
		User userCreate = userService.createUser(mockUser);
		
		// Verificar o resultado
		assertEquals("Gustavo Fernandes", userCreate.getNome());
		assertEquals( "gustavo@gmail.com", userCreate.getEmail());
		assertEquals("11969122212", userCreate.getCelular());
		assertEquals(2, userCreate.getRole().getCode());
		assertEquals(RoleUser.USUARIO, userCreate.getRole());
		assertEquals(dataNascimento, userCreate.getDataNascimento());
		
	}

}
