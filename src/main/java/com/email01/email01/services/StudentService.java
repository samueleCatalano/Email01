package com.email01.email01.services;

import com.email01.email01.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired(required = false)
    Student student;

    List<Student> students = Arrays.asList(
           new Student("1","Samuele", "Catalano", "csamuele73@gmail.com"));

   public Student getStudentById(String studentId) {
       Optional<Student> studentOptional = students.stream().filter(student -> student.getStudentId().equals(studentId)).findAny();
       if (studentOptional.isPresent()) return studentOptional.get();
       return null;
   }

   }
