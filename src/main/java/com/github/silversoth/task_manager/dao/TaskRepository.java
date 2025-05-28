package com.github.silversoth.task_manager.dao;

import com.github.silversoth.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
