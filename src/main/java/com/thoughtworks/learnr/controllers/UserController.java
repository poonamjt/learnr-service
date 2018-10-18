package com.thoughtworks.learnr.controllers;

import com.thoughtworks.learnr.models.User;
import com.thoughtworks.learnr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllItems();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addItem( @Valid @RequestBody User user )
                         {
        if(userService.addUser(user.getUserId(),user.getName()) != null){
            return new ResponseEntity( HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
