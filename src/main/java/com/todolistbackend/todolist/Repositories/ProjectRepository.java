package com.todolistbackend.todolist.Repositories;

import com.todolistbackend.todolist.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT projectname FROM Project u WHERE u.creator = ?1", nativeQuery = true)
    List<String> findByCreator(String username);
}
