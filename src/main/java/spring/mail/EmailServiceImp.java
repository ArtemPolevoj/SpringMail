package spring.mail;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class EmailServiceImp  {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        // простое письмо
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);

// письмо с вложением
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper  helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            FileSystemResource file
                    = new FileSystemResource(new File("C:/Users/artem/Desktop/Изображение WhatsApp 2025-03-28 в 13.10.24_a2eb58cf.jpg"));
            helper.addAttachment("Invoice.jpg", file);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }



        mailSender.send(message);

    }
    public void print(){
        System.out.println("Test OK");
    }
}
