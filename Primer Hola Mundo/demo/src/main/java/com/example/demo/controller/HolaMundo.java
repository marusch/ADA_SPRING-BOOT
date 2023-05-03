package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {

    @GetMapping("/")
    public String hello(){
        return "Hola Mundo";
    }
}
