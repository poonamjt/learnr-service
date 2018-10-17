package com.thoughtworks.learnr.services;

import com.thoughtworks.learnr.models.User;
import com.thoughtworks.learnr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public List<User> getAllItems(){
        return userRepository.findAll();
    }

    public User addUser(long id,String name) {
        User user = new User();
        user.setUserId(id);
        user.setName(name);
        return userRepository.save(user);
    }

}
