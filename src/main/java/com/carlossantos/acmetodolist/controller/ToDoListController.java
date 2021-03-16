package com.carlossantos.acmetodolist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlossantos.acmetodolist.entity.ToDoList;
import com.carlossantos.acmetodolist.service.ToDoListService;

@RestController
@RequestMapping("/api/v1/todolist")
public class ToDoListController {

	private ToDoListService toDoListService;
	
	@Autowired
	public ToDoListController(ToDoListService toDoListService) {
		this.toDoListService = toDoListService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable (value = "id") Long id) {
		return new ResponseEntity<>(toDoListService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(toDoListService.findAllList(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createList(@RequestBody @Valid ToDoList toDoList) {
		return new ResponseEntity<>(toDoListService.createList(toDoList), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteList(@PathVariable (value = "id") Long id){
		toDoListService.deleteList(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<?> updateList(@PathVariable (value = "id") Long id,
										@RequestBody @Valid ToDoList toDoList){
		
		return new ResponseEntity<>(toDoListService.updateList(id, toDoList), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/addtask/{id}")
	public ResponseEntity<?> updateTaskList(@PathVariable (value = "id") Long id,
											@RequestBody @Valid ToDoList toDoList){
		
		return new ResponseEntity<>(toDoListService.updateTaskList(id, toDoList), HttpStatus.OK);
	}
	
}
