package com.example.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("olga.gurkovskaya@gmail.com");
        message.setTo(to);
        message.setText(text);
        emailSender.send(message);
    }
}
