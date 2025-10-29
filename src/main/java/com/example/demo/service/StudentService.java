package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        // Data awal (dummy)
        students.add(new Student("001", "Ali Ahmad", LocalDate.of(2002, 4, 1), "Jakarta"));
        students.add(new Student("002", "Budi Santoso", LocalDate.of(2001, 8, 10), "Bandung"));
        students.add(new Student("003", "Citra Dewi", LocalDate.of(2000, 12, 25), "Surabaya"));
    }

    // CREATE
    public Student createStudent(StudentRequest request) {
        String nim = String.format("%03d", students.size() + 1);
        Student student = new Student(nim, request.getFullName(), request.getDob(), request.getAddress());
        students.add(student);
        return student;
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return students;
    }

    // READ BY NIM
    public Student getStudentByNim(String nim) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getNim().equalsIgnoreCase(nim))
                .findFirst();

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new RuntimeException("Student with nim " + nim + " not found");
        }
    }

    // UPDATE
    public Student updateStudent(String nim, StudentRequest request) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getNim().equalsIgnoreCase(nim))
                .findFirst();

        if (studentOptional.isPresent()) {
            Student studentToUpdate = studentOptional.get();
            studentToUpdate.setFullName(request.getFullName());
            studentToUpdate.setDob(request.getDob());
            studentToUpdate.setAddress(request.getAddress());
            return studentToUpdate;
        } else {
            throw new RuntimeException("Student with nim " + nim + " not found");
        }
    }

    // DELETE
    public void deleteStudent(String nim) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getNim().equalsIgnoreCase(nim))
                .findFirst();

        if (studentOptional.isPresent()) {
            Student studentToBeDeleted = studentOptional.get();
            students.remove(studentToBeDeleted);
        } else {
            throw new RuntimeException("Student with nim " + nim + " not found");
        }
    }
}
