package com.github.silversoth.task_manager.controller;

import com.github.silversoth.task_manager.dao.TaskRepository;
import org.springframework.stereotype.Controller;

import com.github.silversoth.task_manager.entity.Task;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/tasks";
    }


    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("task", new Task());
        return "index";
    }

    @PostMapping("/tasks")
    public String saveTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(!task.isCompleted());
            taskRepository.save(task);
        }
        return "redirect:/tasks";
    }
}
