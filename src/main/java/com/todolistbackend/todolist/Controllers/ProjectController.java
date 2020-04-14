package com.todolistbackend.todolist.Controllers;

import com.todolistbackend.todolist.Services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectServices projectServices;


    @PostMapping("projects/getProjects")
    public List<String> getProjects(@RequestBody String username) {

        List<String> projects = projectServices.getProjects(username);
        return projects;
    }

    @PostMapping("projects/createProject")
    public String createProject(@RequestBody String[] usernameAndProjectName) {

        projectServices.createProjects(usernameAndProjectName[0], usernameAndProjectName[1]);
        return "Success";
    }
}
