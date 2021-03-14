package com.carlossantos.acmetodolist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlossantos.acmetodolist.entity.Task;
import com.carlossantos.acmetodolist.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	
	private TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listAllTaskById(@PathVariable (value = "id") Long id ){
		return new ResponseEntity<>(taskService.listAllTaskById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTaskList(@PathVariable (value = "id") Long id,
											@RequestBody @Valid Task task){
		return new ResponseEntity<>(taskService.updateTaskList(id, task), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable (value = "id") Long id){
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
