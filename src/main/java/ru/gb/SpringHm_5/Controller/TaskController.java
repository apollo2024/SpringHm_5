package ru.gb.SpringHm_5.Controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.SpringHm_5.Models.Task;
import ru.gb.SpringHm_5.Services.TaskService;
import ru.gb.SpringHm_5.Status.TaskStatus;

import java.util.List;

public class TaskController {
    private final TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }

}
