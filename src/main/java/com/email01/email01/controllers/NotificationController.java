package com.email01.email01.controllers;

import com.email01.email01.dto.NotificationDTO;
import com.email01.email01.entities.Student;
import com.email01.email01.services.EmailService;
import com.email01.email01.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    EmailService emailService;

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity sendMail(@RequestBody NotificationDTO payload){
        try {
            Student studentToSendNotification = studentService.getStudentById(payload.getContactId());
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find the answer");
            } else {
                emailService.sendTo(studentToSendNotification.getEmail(), payload.getTitle(), payload.getText());
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
