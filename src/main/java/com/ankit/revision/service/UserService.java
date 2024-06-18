package com.ankit.revision.service;

import com.ankit.revision.model.User;
import com.ankit.revision.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }
}
