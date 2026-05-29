package com.losqdev.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losqdev.taskmanager.dto.TaskRequestDTO;
import com.losqdev.taskmanager.dto.TaskResponseDTO;
import com.losqdev.taskmanager.entity.Task;
import com.losqdev.taskmanager.exception.TaskNotFoundException;
import com.losqdev.taskmanager.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<TaskResponseDTO> findAll() {
		return taskRepository.findAll()
				.stream()
				.map(TaskResponseDTO::new)
				.collect(Collectors.toList());
	}

	public TaskResponseDTO findById(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		return new TaskResponseDTO(task);
	}

	public TaskResponseDTO save(TaskRequestDTO dto) {
		Task task = new Task();
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setCompleted(dto.isCompleted());
		return new TaskResponseDTO(taskRepository.save(task));
	}

	public void delete(Long id) {
		taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		taskRepository.deleteById(id);
	}

}
