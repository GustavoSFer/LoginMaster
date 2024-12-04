package br.com.fernandes.controller;

import br.com.fernandes.entities.User;
import br.com.fernandes.enums.RoleUser;
import br.com.fernandes.service.EmailService;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<String> sendTestEmail() {
    	// ANTIGO
//        emailService.sendSimpleEmail(
//                "gustavo.sfernander@gmail.com", // E-mail do destinatário
//                "Teste de Envio de E-mail", // Assunto
//                "Este é um e-mail de teste enviado do Spring Boot." // Corpo do e-mail
//        );
    	 Calendar calendar = Calendar.getInstance();
         calendar.set(1995, Calendar.MAY, 15); // Ano, mês (0-indexed), dia
         Date dataNascimento = (Date) calendar.getTime();
         
    	User user = new User("Gu","gustavo.sfernander@gmail.com", "12345", "1156555625", RoleUser.ADMINISTRADOR, dataNascimento);
    	 emailService.sendSimpleEmail(
    			 user, // user criado
                 "Teste de Envio de E-mail" // Assunto
                 
         );
        return ResponseEntity.ok("E-mail enviado com sucesso!"); // Retornando uma resposta HTTP com status 200 OK
    }
}
