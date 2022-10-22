package com.email01.email01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

   public void sendTo(String email, String title, String text){
       SimpleMailMessage sms = new SimpleMailMessage();
       sms.setTo(email);
       sms.setFrom("f4kemailt3st@gmail.com");
       sms.setReplyTo("f4kemailt3st@gmail.com");
       sms.setSubject(title);
       sms.setText(text);
       mailSender.send(sms);
   }


}
