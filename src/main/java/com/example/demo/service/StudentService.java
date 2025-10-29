package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        // Data awal
        students.add(new Student("001", "Ali Ahmad", java.time.LocalDate.of(2002, 4, 1), "Jakarta"));
        students.add(new Student("002", "Budi Santoso", java.time.LocalDate.of(2001, 8, 10), "Bandung"));
    }

    // CREATE
    public Student createStudent(StudentRequest request) {
        String nim = String.format("%03d", students.size() + 1);
        Student student = new Student(nim, request.getFullName(), request.getDob(), request.getAddress());
        students.add(student);
        return student;
    }

    // READ - Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // READ - Get by NIM
    public Student getStudentByNim(String nim) {
        return students.stream()
                .filter(s -> s.getNim().equalsIgnoreCase(nim))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public Student updateStudent(String nim, StudentRequest request) {
        Student existing = getStudentByNim(nim);
        if (existing != null) {
            existing.setFullName(request.getFullName());
            existing.setDob(request.getDob());
            existing.setAddress(request.getAddress());
        }
        return existing;
    }

    // DELETE
    public boolean deleteStudent(String nim) {
        Student existing = getStudentByNim(nim);
        if (existing != null) {
            students.remove(existing);
            return true;
        }
        return false;
    }
}
