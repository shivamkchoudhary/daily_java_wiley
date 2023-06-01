//package com.example.demo.controller;
//
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Value;
//
//
//@RestController
//public class HelloController {
//
//    @Value("${welcome.message}")
//    private String msg;
//
//    @GetMapping("/")
//    public String helloworld() {
////        return "Welcome to Spring Boot... 👻";
//        return msg;
//    }
//}