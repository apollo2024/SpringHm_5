package ru.gb.SpringHm_5.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.SpringHm_5.Models.Task;
import ru.gb.SpringHm_5.Status.TaskStatus;


import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
