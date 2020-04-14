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

    public boolean createNewUser(User user) {
        String encryptedPassword = encryptPassword(user.getUserpassword());
        user.setUserpassword(encryptedPassword);
        User tempUser = new User();
        tempUser.setUsername(user.getUsername());
        tempUser.setUserpassword(user.getUserpassword());
        boolean isUserCreated = false;
        List<User> users = userRepository.findByUsername(user.getUsername());
        if (userRepository.findByUsername(user.getUsername()).size() == 0) {
            userRepository.save(tempUser);
            isUserCreated = true;
        }
        return isUserCreated;
    }

    @CrossOrigin
    public boolean validateUsernameAndPasswordCombination(String username, String userpassword) {
        boolean userValidationCheck = false;
        if (userRepository.findByUsername(username) != null) {
            if (checkPw(userpassword, encryptPassword(userpassword))) {
                userValidationCheck = true;
            }
        }
        return userValidationCheck;
    }


    //Private Helper Methods for Logic in User Service
    private boolean validateUserNameById(String userName) {

        List<User> repoResults = userRepository.findByUsername(userName);
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

    public List<String> readAllUsers(String firstCharacter) {
        return userRepository.findByFirstCharacter(firstCharacter);
    }
}
