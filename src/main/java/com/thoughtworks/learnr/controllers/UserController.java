package com.thoughtworks.learnr.controllers;

import com.thoughtworks.learnr.models.User;
import com.thoughtworks.learnr.repositories.UserRepository;
import com.thoughtworks.learnr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    UserService userService;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllItems();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addItem(@RequestParam("userId") long userId,
                          @RequestParam("name") String name)
                         {
        if(userService.addUser(userId,name) != null){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
