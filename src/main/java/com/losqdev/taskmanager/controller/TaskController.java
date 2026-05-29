package com.losqdev.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losqdev.taskmanager.dto.TaskRequestDTO;
import com.losqdev.taskmanager.dto.TaskResponseDTO;
import com.losqdev.taskmanager.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<TaskResponseDTO> findAll() {
		return taskService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(taskService.findById(id));
	}

	@PostMapping
	public ResponseEntity<TaskResponseDTO> save(@Valid @RequestBody TaskRequestDTO dto) {
		TaskResponseDTO saved = taskService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		taskService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
