package com.github.silversoth.task_manager.controller;

import com.github.silversoth.task_manager.dao.TaskRepository;
import com.github.silversoth.task_manager.service.TaskService;
import org.springframework.stereotype.Controller;
import com.github.silversoth.task_manager.entity.Task;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@Tag(name = "Task Controller", description = "Handles task operations for the web app")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Redirect root URL to tasks page")
    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/tasks";
    }

    @Operation(summary = "List all tasks and show form")
    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task());
        return "index";
    }

    @Operation(summary = "Save a new task")
    @PostMapping("/tasks")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @Operation(summary = "Delete a task by ID")
    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @Operation(summary = "Toggle completion status of a task")
    @GetMapping("/tasks/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        taskService.toggleTaskCompletion(id);
        return "redirect:/tasks";
    }
}
