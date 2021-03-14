package com.carlossantos.acmetodolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossantos.acmetodolist.entity.ToDoList;
import com.carlossantos.acmetodolist.repository.ToDoListRepository;

@Service
public class ToDoListService {

	private ToDoListRepository toDoListRepository;
	
	//private final ToDoListMapper toDoListMapper = ToDoListMapper.INSTANCE;
	
	/*@Autowired
	private ToDoListMapper toDoListMapper;*/
	
	@Autowired
	public ToDoListService(ToDoListRepository toDoListRepository) {
		this.toDoListRepository = toDoListRepository;
		
	}
	
	public ToDoList findById(Long id){
		Optional<ToDoList> toDoList = this.toDoListRepository.findById(id);
		
		if(toDoList.isPresent()) {
			return toDoList.get();
		}else {
			//TODO exception
			return null;
		}
		
	}
	
	public List<ToDoList> findAllList() {
		return this.toDoListRepository.findAll();
	}
	
	public ToDoList createList(ToDoList toDoList) {
		ToDoList toDoSave = toDoList;
		toDoSave.getTask().forEach(task -> task.setToDoList(toDoSave));
		
		toDoListRepository.save(toDoSave);
		
		return toDoSave;
	}
	
	public void deleteList(Long id) {
		Optional <ToDoList> toDoList = this.toDoListRepository.findById(id);
		
		if(toDoList.isPresent()) {
			this.toDoListRepository.delete(toDoList.get());
		}else {
			//TODO exception
		}
	}
	
	public ToDoList updateList(Long id, ToDoList toDoList){
		Optional<ToDoList> toDoForCheck = this.toDoListRepository.findById(id);
		ToDoList toDoListUpdated = toDoList;
		
		if(toDoForCheck.isPresent()) {
			ToDoList toDoForUpdate = toDoForCheck.get();
			toDoForUpdate.setNameList(toDoListUpdated.getNameList());
			
			return this.toDoListRepository.save(toDoForUpdate);
			
		}else {
			//TODO exception
			return null;
		}
	}
	
	public ToDoList updateTaskList(Long id, ToDoList toDoList) {
		Optional<ToDoList> toDoForCheck = this.toDoListRepository.findById(id);
		ToDoList toDoListUpdated = toDoList;
		
		if(toDoForCheck.isPresent()) {
			ToDoList toDoForUpdate = toDoForCheck.get();
			toDoListUpdated.getTask().forEach(task -> task.setToDoList(toDoForUpdate));
			toDoForUpdate.setTask(toDoListUpdated.getTask());
			
			//toDoForUpdate.getTask().forEach(task -> task.setToDoList(toDoListUpdated));
			
			this.toDoListRepository.save(toDoForUpdate);
			
			return toDoForUpdate;
			
		}else {
			//TODO exception
			return null;
		}
	}

	
}
