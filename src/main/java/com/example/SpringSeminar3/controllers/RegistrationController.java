package com.example.SpringSeminar3.controllers;


import com.example.SpringSeminar3.domain.User;
import com.example.SpringSeminar3.services.DataProcessingService;
import com.example.SpringSeminar3.services.NotificationService;
import com.example.SpringSeminar3.services.RegistrationService;
import com.example.SpringSeminar3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("email") String email){
        registrationService.registerUser(name, age, email);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/sortbyage")
    public ResponseEntity<List<User>> sortByAge(){
        notificationService.notifyUser(null, "Users sorting by age.");
       return ResponseEntity.ok(dataProcessingService.sortUsersByAge(userService.getUsers()));
    }

    @GetMapping("/filtertbyage")
    public ResponseEntity<List<User>> sortByAge(@RequestParam() int age){
        notificationService.notifyUser(null, "Filtering users by age.");
        return ResponseEntity.ok(dataProcessingService.filterUsersByAge(userService.getUsers(), age));
    }

    @GetMapping("/calcavgage")
    public ResponseEntity<Double> calcAverageAge(){
        notificationService.notifyUser(null, "Calculating average age of users.");
        return ResponseEntity.ok(dataProcessingService.calculateAverageAge(userService.getUsers()));
    }
}
