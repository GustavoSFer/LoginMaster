package br.com.fernandes.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import br.com.fernandes.entities.User;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleEmail(User user, String subject) {
    	try {
//        SimpleMailMessage message = new SimpleMailMessage();
//        
//        message.setFrom("gustavoSpringBoot@gmail.com"); // Seu e-mail
//        message.setTo(to); // E-mail do destinatário
//        message.setSubject(subject); // Assunto do e-mail
//        message.setText(text); // Corpo do e-mail
//        emailSender.send(message);
    		
    		
    		MimeMessage message = emailSender.createMimeMessage();
    		MimeMessageHelper helper = new MimeMessageHelper(message, true);
    		
    		helper.setFrom("noreply@gmail.com");
    		helper.setSubject(subject);
    		helper.setTo(user.getEmail());
    		
    		String template = carregaTamplateEmail();
    		
    		template = template.replace("[nome]", user.getNome());
    		
    		helper.setText(template, true);
    		emailSender.send(message);
			
    		
    	} catch( Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public String carregaTamplateEmail() throws IOException {
    	ClassPathResource resource = new ClassPathResource("EmailConfirmacao.html");
    	
    	return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
