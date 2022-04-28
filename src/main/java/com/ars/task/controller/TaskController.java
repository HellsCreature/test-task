package com.ars.task.controller;

import com.ars.task.model.Task;
import com.ars.task.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
Controller class for Tasks
 */
@RestController
@Api(produces = "application/json", value = "Operations to get, add or update information about tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @ApiOperation(value = "View all tasks", response = Iterable.class, produces = "application/json")
    List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @GetMapping("/tasks/{id}")
    @ApiOperation(value = "Get task with specified id", response = Task.class, produces = "application/json")
    Task getTask(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping(path = "/tasks")
    @ApiOperation(value = "Create a new task", response = Task.class, produces = "application/json")
    Task newTask(@RequestBody Task task) {
        return taskService.saveNewTask(task);
    }

    @PutMapping("/tasks/{id}")
    @ApiOperation(value = "Update information for task with specified id", response = Task.class, produces = "application/json")
    Task editTask(@RequestBody Task task, @PathVariable Long id) {
        return taskService.editTask(task, id);
    }

    @DeleteMapping("/tasks/{id}")
    @ApiOperation(value = "Delete task with specified id")
    void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/projects/{id}/tasks")
    @ApiOperation(value = "View all tasks for project with specified id", response = Iterable.class, produces = "application/json")
    List<Task> getProjectTasks(@PathVariable Long id) {
        return taskService.getProjectTasks(id);
    }

}
