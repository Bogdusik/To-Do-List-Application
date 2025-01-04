package com.todolist.todolist.controller;

import com.todolist.todolist.model.ActionLog;
import com.todolist.todolist.model.Task;
import com.todolist.todolist.repository.ActionLogRepository;
import com.todolist.todolist.repository.TaskRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@Controller
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;
    private final ActionLogRepository actionLogRepository;

    public TaskController(TaskRepository taskRepository, ActionLogRepository actionLogRepository) {
        this.taskRepository = taskRepository;
        this.actionLogRepository = actionLogRepository;
    }

    @GetMapping("/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("actions", actionLogRepository.findAll());
        logger.info("Listed all tasks and actions");
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setCompleted(false);
        taskRepository.save(task);

        ActionLog actionLog = new ActionLog("Added Task: {}", description, true);
        actionLogRepository.save(actionLog);

        logger.info("Added task: {}", description);
        return "redirect:/";
    }

    @PostMapping("/completeTask/{id}")
    public String completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            logger.error("Task with ID {} not found", id);
            return "redirect:/error";
        }
        task.setCompleted(true);
        taskRepository.save(task);

        ActionLog actionLog = new ActionLog("Completed Task with ID: " + id, task.getDescription(), true);
        actionLogRepository.save(actionLog);

        logger.info("Completed task with ID: {}", id);
        return "redirect:/";
    }

    @PostMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            logger.error("Task with ID {} not found", id);
            return "redirect:/error";
        }

        taskRepository.deleteById(id);

        ActionLog actionLog = new ActionLog("Deleted Task with ID: " + id, task.getDescription(), true);
        actionLogRepository.save(actionLog);

        logger.info("Deleted task with ID: {}", id);
        return "redirect:/";
    }


    @ExceptionHandler(NoSuchElementException.class)
    public String handleTaskNotFound(NoSuchElementException e, Model model) {
        logger.error("Task not found: {}", e.getMessage());
        model.addAttribute("error", "Task not found");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGlobalError(Exception e, Model model) {
        logger.error("An error occurred: {}", e.getMessage());
        model.addAttribute("error", "An unexpected error occurred");
        return "error";
    }
}