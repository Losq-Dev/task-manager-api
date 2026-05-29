package com.losqdev.taskmanager.dto;

import java.time.LocalDateTime;

import com.losqdev.taskmanager.entity.Task;

public class TaskResponseDTO {

	private Long id;
	private String title;
	private String description;
	private boolean completed;
	private LocalDateTime createdAt;
	
	public TaskResponseDTO() {
	}
	
	public TaskResponseDTO(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.completed = task.isCompleted();
		this.createdAt = task.getCreatedAt();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
}
