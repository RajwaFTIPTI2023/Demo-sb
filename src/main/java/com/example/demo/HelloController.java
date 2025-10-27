package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello, wwWorld!";
    }

    
    @GetMapping("/ping")
    public String piing() {
        return "poing";
    }

    @GetMapping("/ping1")
    public String piing1 () {
        return "poisssng";
    }

      @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    // Tambahkan endpoint student di bawah ini
    private final List<Student> students = new ArrayList<>();

    public HelloController() {
        students.add(new Student("2312500107", "Rajwa Yanhar Pradipta", "2005-8-10", "Ciledug"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student " + student.getFullName() + " berhasil ditambahkan!";
    }

}
