package com.droid08.SpringSecurtyEx.controller;

import com.droid08.SpringSecurtyEx.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Vishal", 85.45f),
        new Student(2, "vishal2", 88.76f)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        System.out.println("Get Request Detected for students list. - this from StudentController.java getStudents() method System.out.println() line no. ~22");
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        System.out.println("Post Request Detected for add student in list. - this from StudentController.java addStudent() method System.out.println() line no. ~33");
        students.add(student);
        return student; // not return list, only return added student
    }
}
