package com.losqdev.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequestDTO {
	
	@NotBlank(message = "O título é obrigatório")
	@Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres")
	private String title;
	
	@Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
	private String description;
	
	private boolean completed;
	
	public TaskRequestDTO() {
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
