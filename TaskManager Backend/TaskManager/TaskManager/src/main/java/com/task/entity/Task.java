package com.task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks") // Ensure the table name is correct
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure ID auto-increments
	private Long id;

	private String title;
	private String description;
	private boolean completed;

	public Task() {
	}

	public Task(String title, String description, boolean completed) {
		this.title = title;
		this.description = description;
		this.completed = completed;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
