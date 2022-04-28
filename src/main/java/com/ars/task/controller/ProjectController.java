package com.ars.task.controller;

import com.ars.task.model.Project;
import com.ars.task.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
Controller class for Projects
 */
@RestController
@Api(produces = "application/json", value = "Operations to get, add or update information about projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    @ApiOperation(value = "View all projects", response = Iterable.class, produces = "application/json")
    List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @GetMapping("/projects/{id}")
    @ApiOperation(value = "Get project with specified id", response = Project.class, produces = "application/json")
    Project getProject(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping(path = "/projects")
    @ApiOperation(value = "Create a new project", response = Project.class, produces = "application/json")
    Project newProject(@RequestBody Project project) {
        return projectService.saveNewProject(project);
    }

    @PutMapping("/projects/{id}")
    @ApiOperation(value = "Update information for project with specified id", response = Project.class, produces = "application/json")
    Project editProject(@RequestBody Project project, @PathVariable Long id) {
        return projectService.editProject(project, id);
    }

    @DeleteMapping("/projects/{id}")
    @ApiOperation(value = "Delete project with specified id and all tasks within the project")
    void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

}
