package com.major.kisaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.major.kisaan.services.UserServices;
import com.major.kisaan.user.User;

@RestController
@CrossOrigin
public class MyControls {
	
	@Autowired
    private final UserServices userService;

    public MyControls(UserServices userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        System.out.println("user-->"+new Gson().toJson(user));
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestParam String phoneNumber, @RequestParam String password) {
        User user = userService.login(phoneNumber, password);
        System.out.println("user-->"+new Gson().toJson(user));
        if (user != null) {
            return "Login successful! Welcome, " + user.getName();
        }
        return "Invalid phone number or password.";
    }
}

