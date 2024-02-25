package ru.gb.SpringHm_5.Models;

import jakarta.persistence.*;
import lombok.Data;
import ru.gb.SpringHm_5.Status.TaskStatus;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="tasks")
public class Task {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.NOT_STARTED;

    private LocalDateTime createdAt = LocalDateTime.now();
}