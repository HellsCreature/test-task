package com.ars.task.repository;

import com.ars.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    @Transactional
    Long deleteByProjectId(Long projectId);
}
