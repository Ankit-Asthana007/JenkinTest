package com.ankit.revision.controller;


import com.ankit.revision.model.User;
import com.ankit.revision.repo.UserRepo;
import com.ankit.revision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public void saveUser(User user) {
        userService.saveUser(user);
    }
}
