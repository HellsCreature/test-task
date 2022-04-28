package com.ars.task.service;

import com.ars.task.exeptions.BusinessErrorException;
import com.ars.task.exeptions.ProjectNotFoundException;
import com.ars.task.exeptions.TaskNotFoundException;
import com.ars.task.model.Task;
import com.ars.task.model.TaskStatus;
import com.ars.task.repository.ProjectRepository;
import com.ars.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
Service class for Tasks
All logic before write to db is here
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        }
        else {
            throw new TaskNotFoundException(id);
        }
    }

    /* Update existing task or create new */
    public Task editTask(Task newTask, Long id) {
        Task task;
        try{
            task = findById(id);
            task.setName(newTask.getName());
            task.setStatus(newTask.getStatus());
            task.setDescription(newTask.getDescription());
            task.setPriority(newTask.getPriority());
            task.setProjectId(newTask.getProjectId());
            task = saveTask(task);
        }
        catch (ProjectNotFoundException e) {
            task = saveNewTask(newTask);
        }
        return task;
    }

    public Task saveNewTask(Task task) {
        /*Nullify id since it generated*/
        task.setId(null);
        return saveTask(task);
    }

    private Task saveTask(Task task) {
        checkAndFillTask(task);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getProjectTasks(Long id) {
        return taskRepository.findByProjectId(id);
    }

    /* Checking for mandatory fields and fill some default values */
    private void checkAndFillTask(Task task) {
        if (task.getProjectId()==null) {
            throw new BusinessErrorException("\"projectId\" is mandatory.");
        }
        if (!projectRepository.existsById(task.getProjectId())) {
            throw new ProjectNotFoundException(task.getProjectId());
        }
        if (task.getName()==null) {
            throw new BusinessErrorException("\"name\" is mandatory.");
        }
        if (task.getStatus()==null) {
            task.setStatus(TaskStatus.ToDo);
        }
        if(task.getPriority()==null) {
            task.setPriority(0);
        }
    }

}
