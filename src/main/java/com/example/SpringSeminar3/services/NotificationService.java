package com.example.SpringSeminar3.services;

import com.example.SpringSeminar3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user, String message) {
        if (user != null) {
            System.out.println(message + user.getName());
        } else {
            System.out.println(message);
        }
    }
}
