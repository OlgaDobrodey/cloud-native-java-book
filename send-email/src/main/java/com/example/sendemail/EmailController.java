package com.example.sendemail;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email")
    public void getResultNumberToWords(@RequestBody EmailDto emailDto) {
        emailService.sendSimpleMessage(emailDto.email, emailDto.text);
    }

}
