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

    @PostMapping("/user/registration-management")
    public String createNewUser(@RequestBody User user) {
       return userServices.createNewUser(user);
    }

    @PostMapping("/user/login-management")
    public boolean validateUserLoginAttempt(@RequestHeader String username, @RequestHeader String userpassword) {
        return userServices.validateUsernameAndPasswordCombination(username, userpassword);
    }

}
