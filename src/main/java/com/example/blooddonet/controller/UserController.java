package com.example.blooddonet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/login")
    public String login() {
        return "LogIn";
    }

//    @GetMapping("/public")
//    public String publicPage() {
//        return "public";
//    }
//
//    @GetMapping("/private")
//    public String privatePage() {
//        return "private";
//    }
}
