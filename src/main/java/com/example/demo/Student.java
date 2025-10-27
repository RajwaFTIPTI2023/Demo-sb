package com.example.demo; // samakan dengan package project kamu

public class Student {
    private String nim;
    private String fullName;
    private String dob;
    private String address;

    public Student() {}

    public Student(String nim, String fullName, String dob, String address) {
        this.nim = nim;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
