package com.task.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.dao.TaskRepository;
import com.task.entity.Task;

@Service
public class TaskService {
    private final TaskRepository repository;
    public TaskService(TaskRepository repository) { this.repository = repository; }
    public List<Task> getAllTasks() { return repository.findAll(); }
    public Task createTask(Task task) { return repository.save(task); }
    public void deleteTask(Long id) { repository.deleteById(id); }
}