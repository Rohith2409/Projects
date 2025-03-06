package com.task.controller;

import org.springframework.web.bind.annotation.*;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.task.dao.TaskRepository;
import com.task.entity.Task;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*") // Allow all origins temporarily
//@CrossOrigin(origins = "http://localhost:5500") // Adjust if needed
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
	}

	@PutMapping("/{id}/toggle")
	public Task toggleTaskStatus(@PathVariable Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
		task.setCompleted(!task.isCompleted()); // Toggle completed status
		return taskRepository.save(task);
	}

//    @PutMapping("/{id}/complete")
//    public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
//        Optional<Task> optionalTask = taskRepository.findById(id);
//        if (optionalTask.isPresent()) {
//            Task task = optionalTask.get();
//            task.setCompleted(true); // Mark as complete
//            taskRepository.save(task);
//            return ResponseEntity.ok(task);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
	@PutMapping("/{id}/complete")
	public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
		task.setCompleted(true);
		taskRepository.save(task);
		return ResponseEntity.ok(task);
	}

}
