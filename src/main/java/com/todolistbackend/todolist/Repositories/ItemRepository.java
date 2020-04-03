package com.todolistbackend.todolist.Repositories;

import com.todolistbackend.todolist.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT r.uniqueuserid FROM User r WHERE r.uniqueuserid = ?1", nativeQuery = true)
    List<Item> findItemsByUsername(String username);



}
