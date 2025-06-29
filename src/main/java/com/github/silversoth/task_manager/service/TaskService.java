package com.github.silversoth.task_manager.service;

import com.github.silversoth.task_manager.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task saveTask(Task task);
    void deleteTask(Long id);
    Task toggleTaskCompletion(Long id);
}
