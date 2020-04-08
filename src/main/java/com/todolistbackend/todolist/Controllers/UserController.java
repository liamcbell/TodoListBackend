package com.todolistbackend.todolist.Controllers;

import com.todolistbackend.todolist.Entities.User;
import com.todolistbackend.todolist.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/user/registration")
    public boolean createNewUser(@RequestBody User user) {
       return userServices.createNewUser(user);
    }

    @PostMapping("/user/login")
    public boolean validateUserLoginAttempt(@RequestBody User user) {
        return userServices.validateUsernameAndPasswordCombination(user.getUsername(), user.getUserpassword());
    }

}
