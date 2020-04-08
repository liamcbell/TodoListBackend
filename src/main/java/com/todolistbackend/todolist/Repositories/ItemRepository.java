package com.todolistbackend.todolist.Repositories;

import com.todolistbackend.todolist.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT * FROM Item r WHERE r.username = ?1 AND r.status = ?2", nativeQuery = true)
    List<Item> findItemsByUsernameAndStatus(String username, String status);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Item i WHERE i.username = ?1 AND i.status = ?2", nativeQuery = true)
    void deleteItemsWhereUsernameAndStatus(String username, String status);




}
