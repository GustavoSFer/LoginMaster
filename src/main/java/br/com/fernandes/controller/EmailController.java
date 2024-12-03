package br.com.fernandes.controller;

import br.com.fernandes.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        emailService.sendSimpleEmail(
                "gustavo.sfernander@gmail.com", // E-mail do destinatário
                "Teste de Envio de E-mail", // Assunto
                "Este é um e-mail de teste enviado do Spring Boot." // Corpo do e-mail
        );
        return ResponseEntity.ok("E-mail enviado com sucesso!"); // Retornando uma resposta HTTP com status 200 OK
    }
}
