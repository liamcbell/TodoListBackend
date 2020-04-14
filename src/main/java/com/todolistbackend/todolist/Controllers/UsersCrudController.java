package com.todolistbackend.todolist.Controllers;

import com.todolistbackend.todolist.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersCrudController {

    @Autowired
    UserServices userServices;


    @PostMapping(value = "/user/search")
    public List<String> userRead(@RequestBody String firstCharacter) {
        List<String> usersToReturn = userServices.readAllUsers(firstCharacter);
        return usersToReturn;
    }
}
