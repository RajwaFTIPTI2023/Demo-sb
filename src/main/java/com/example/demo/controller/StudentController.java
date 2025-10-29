package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRequest;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE
    @PostMapping
    public Student createStudent(@RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ BY NIM
    @GetMapping("/{nim}")
    public Object findStudent(@PathVariable String nim) {
        try {
            return studentService.getStudentByNim(nim);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // UPDATE
    @PutMapping("/{nim}")
    public Object updateStudent(@PathVariable String nim, @RequestBody StudentRequest request) {
        try {
            return studentService.updateStudent(nim, request);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // DELETE
    @DeleteMapping("/{nim}")
    public String removeStudent(@PathVariable String nim) {
        try {
            studentService.deleteStudent(nim);
            return "Successfully deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
