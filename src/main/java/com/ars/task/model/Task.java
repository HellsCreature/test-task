package com.ars.task.model;

import javax.persistence.*;
import java.util.Objects;
/*
Representation for "tasks" table
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /* Project id which task belong to */
    private Long projectId;
    private String name;
    private TaskStatus status;
    private String description;
    private Integer priority;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id) && name.equals(task.name) && status == task.status && projectId.equals(task.projectId) && description.equals(task.description) && priority.equals(task.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, projectId, description, priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", projectId=" + projectId +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
