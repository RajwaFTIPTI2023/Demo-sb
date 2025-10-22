package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
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


}
