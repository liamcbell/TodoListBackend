package com.todolistbackend.todolist.Services;

import com.todolistbackend.todolist.Entities.Project;
import com.todolistbackend.todolist.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServices {

    @Autowired
    ProjectRepository projectRepository;


    public List<String> getProjects(String username) {
        List<String> projects = projectRepository.findByCreator(username);
        return projects;
    }

    public void createProjects(String username, String projectName) {
        Project project = new Project(username, projectName);
        projectRepository.save(project);
    }
}
