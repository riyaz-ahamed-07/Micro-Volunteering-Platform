package com.fullstack.assessment.Controllers;

import com.fullstack.assessment.Entities.TaskEntity;
import com.fullstack.assessment.Services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity task, @RequestParam Long userId, @RequestParam Long orgId) {
        return taskService.createTask(task, userId, orgId);
    }

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable Long id, @RequestBody TaskEntity task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }
}