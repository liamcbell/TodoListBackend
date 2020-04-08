package com.todolistbackend.todolist.Repositories;

import com.todolistbackend.todolist.Entities.User;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM User u WHERE u.username = ?1", nativeQuery = true)
    List<User> findByUsername(String username);

    @Query(value = "SELECT * FROM User u WHERE u.username = ?1 AND u.userpassword = ?2", nativeQuery = true)
    User findByUsernameAndUserpassword(String username, String userpassword);

}
