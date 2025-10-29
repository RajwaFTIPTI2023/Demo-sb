package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRequest;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest request) {
        Student student = studentService.createStudent(request);
        return ResponseEntity.ok(student);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // READ BY NIM
    @GetMapping("/{nim}")
    public ResponseEntity<?> getStudentByNim(@PathVariable String nim) {
        Student student = studentService.getStudentByNim(nim);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(404).body("Student not found");
    }

    // UPDATE
    @PutMapping("/{nim}")
    public ResponseEntity<?> updateStudent(@PathVariable String nim, @RequestBody StudentRequest request) {
        Student updated = studentService.updateStudent(nim, request);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.status(404).body("Student not found");
    }

    // DELETE
    @DeleteMapping("/{nim}")
    public ResponseEntity<String> deleteStudent(@PathVariable String nim) {
        boolean deleted = studentService.deleteStudent(nim);
        if (deleted) {
            return ResponseEntity.ok("Successfully deleted");
        }
        return ResponseEntity.status(404).body("Student not found");
    }
}
