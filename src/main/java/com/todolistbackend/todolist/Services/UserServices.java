package com.todolistbackend.todolist.Services;

import com.todolistbackend.todolist.Entities.User;
import com.todolistbackend.todolist.Repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class UserServices {


    @Autowired
    UserRepository userRepository;
    BCrypt bCrypt;

    public String createNewUser(User user) {
        String encryptedPassword = encryptPassword(user.getUserpassword());
        user.setUserpassword(encryptedPassword);
        userRepository.save(user);
        return "Success";
    }

    @CrossOrigin
    public boolean validateUsernameAndPasswordCombination(String username, String userpassword) {
        boolean userValidationCheck = false;
        if (userRepository.findByUsernameAndUserpassword(username, userpassword) != null) {
            if (validateUserNameById(username) && checkPw(userpassword, userRepository.findByUsernameAndUserpassword(username, userpassword).getUserpassword())) {
                userValidationCheck = true;
            }
        }
        return true;
    }


    //Private Helper Methods for Logic in User Service
    private boolean validateUserNameById(String userName) {

        List<String> repoResults = userRepository.findByUsername(userName);
        if(repoResults.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkPw(String rawTextPassword, String hashPw) {
        return bCrypt.checkpw(rawTextPassword, hashPw);
    }


    private String encryptPassword(String userPassword) {
        return bCrypt.hashpw(userPassword, BCrypt.gensalt(6));
    }
}
