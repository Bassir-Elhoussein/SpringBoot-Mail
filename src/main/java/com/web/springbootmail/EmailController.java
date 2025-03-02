package com.web.springbootmail;

import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody Map<String, Object> request) {
        try {
            List<String> to = (List<String>) request.get("to");
            List<String> cc = (List<String>) request.get("cc");
            String subject = (String) request.get("subject");
            String messageBody = (String) request.get("messageBody");

            emailService.sendEmailWithDesign(to, cc, subject, messageBody);
            return "Email sent successfully!";
        } catch (MessagingException | UnsupportedEncodingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
