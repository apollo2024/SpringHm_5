package ru.gb.SpringHm_5.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.SpringHm_5.Models.Task;
import ru.gb.SpringHm_5.Repo.TaskRepository;
import ru.gb.SpringHm_5.Status.TaskStatus;


import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    @Autowired
    TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task task) {
        Task existingTask = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setStatus(task.getStatus());
        return repository.save(existingTask);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
