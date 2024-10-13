package com.example.SpringSeminar3.repository;

import com.example.SpringSeminar3.domain.User;
import com.example.SpringSeminar3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }
}
