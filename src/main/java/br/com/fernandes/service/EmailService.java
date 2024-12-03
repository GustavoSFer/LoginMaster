package br.com.fernandes.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleEmail(String to, String subject, String text) {
    	try {
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom("gustavoSpringBoot@gmail.com"); // Seu e-mail
        message.setTo(to); // E-mail do destinatário
        message.setSubject(subject); // Assunto do e-mail
        message.setText(text); // Corpo do e-mail
        emailSender.send(message);
    	} catch( Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}
