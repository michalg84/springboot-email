package com.galka.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(Message message) {
        final var mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("emailtestmgg@gmail.com");
        mailMessage.setText(message.getMessage());
        mailMessage.setSubject(message.getSubject());
        mailMessage.setTo(message.getTo());
        mailSender.send(mailMessage);

    }
}
