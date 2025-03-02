package com.web.springbootmail;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithDesign(
            List<String> to, List<String> cc, String subject, String messageBody)
            throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("unfazed7eera9eya@gmail.com", "Bassir Elhoussein");
        helper.setTo(to.toArray(new String[0]));
        if (cc != null && !cc.isEmpty()) {
            helper.setCc(cc.toArray(new String[0]));
        }
        helper.setSubject(subject);

        // Email body with image
        String emailContent = "<html><body style='font-family: Arial, sans-serif; text-align: center;'>"
                + "<img src='cid:headerImage' style='width: 100%; max-width: 600px; margin-bottom: 20px;'/>"
                + "<div style='text-align: left; padding: 20px;'>"
                + messageBody
                + "<br><br>"
                + "<p style='font-weight: bold;'>Best Regards,</p>"
                + "<p>El Houssein Bassir</p>"
                + "<p>Junior Software Engineer</p>"
                + "<p>Email: bassirelhoussein@gmail.com | elhoussein.bassir@um5r.ac.ma</p>"
                + "<p>Phone: +212 6 63 12 47 20</p>"
                + "<p>WhatsApp: +212 6 28 96 87 80</p>"
                + "<p><a href='https://linkedin.com/in/bassir-el-houssein'>LinkedIn</a> | <a href='https://github.com/Bassir-Elhoussein'>GitHub</a></p>"
                + "</div></body></html>";

        helper.setText(emailContent, true);

        // Attach image (header)
        File headerImage = new File("src/main/resources/static/header.png"); // Save the image in src/main/resources/static/
        helper.addInline("headerImage", new ClassPathResource("static/header.png"));

        mailSender.send(message);
    }
}
