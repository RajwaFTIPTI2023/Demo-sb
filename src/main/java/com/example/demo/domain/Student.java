package com.example.demo.domain;

import java.time.LocalDate;

public class Student {
    private String nim;
    private String fullName;
    private LocalDate dob;
    private String address;

    public Student() {}

    public Student(String nim, String fullName, LocalDate dob, String address) {
        this.nim = nim;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
