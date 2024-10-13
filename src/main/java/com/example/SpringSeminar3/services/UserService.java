package com.example.SpringSeminar3.services;

import com.example.SpringSeminar3.domain.User;
import com.example.SpringSeminar3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private NotificationService notificationService;


    private UserRepository userRepository;

    @Autowired// Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

public User createUser(String name, int age, String email) {
    User user = new User();
    user.setName(name);
    user.setAge(age);
    user.setEmail(email);
    // Отправляем уведомление о создании нового пользователя notificationService.notifyUser(user);
    return user;
    }

    public List<User> getUsers(){
        return userRepository.getUsers();
    }
}
