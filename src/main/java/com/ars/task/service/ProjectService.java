package com.ars.task.service;

import com.ars.task.exeptions.BusinessErrorException;
import com.ars.task.exeptions.ProjectNotFoundException;
import com.ars.task.model.Project;
import com.ars.task.model.ProjectStatus;
import com.ars.task.repository.ProjectRepository;
import com.ars.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
Service class for Projects
All logic before write to db is here
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            return optionalProject.get();
        }
        else {
            throw new ProjectNotFoundException(id);
        }
    }

    /* Update existing project or create new */
    public Project editProject(Project newProject, Long id) {
        Project project;
        try{
            project = findById(id);
            project.setName(newProject.getName());
            project.setStartDate(newProject.getStartDate());
            project.setCompletionDate(newProject.getCompletionDate());
            project.setPriority(newProject.getPriority());
            project = saveProject(project);
        }
        catch (ProjectNotFoundException e) {
            project = saveNewProject(newProject);
        }
        return project;
    }

    public Project saveNewProject(Project project){
        /*Nullify id since it generated*/
        project.setId(null);
        return saveProject(project);
    }

    private Project saveProject(Project project) {
        checkAndFillProject(project);
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        taskRepository.deleteByProjectId(id);
        projectRepository.deleteById(id);
    }

    /* Checking for mandatory fields and fill some default values */
    private void checkAndFillProject(Project project) {
        if (project.getName()==null) {
            throw new BusinessErrorException("\"name\" is mandatory.");
        }
        if (project.getStartDate()==null) {
            throw new BusinessErrorException("\"startDate\" is mandatory.");
        }
        if (project.getStatus()==null) {
            project.setStatus(ProjectStatus.NotStarted);
        }
        if (project.getPriority()==null) {
            project.setPriority(0);
        }
    }

}
