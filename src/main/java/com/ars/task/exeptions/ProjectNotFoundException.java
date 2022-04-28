package com.ars.task.exeptions;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Long id) {
        super("Could not find project with id=" + id);
    }
}
