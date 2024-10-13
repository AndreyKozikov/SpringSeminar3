package com.example.SpringSeminar3.services;


import com.example.SpringSeminar3.domain.User;
import com.example.SpringSeminar3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public void registerUser(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        notificationService.notifyUser(user, "A new user has been created: ");
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user, "User add to List: ");
    }
}
