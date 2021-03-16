package com.carlossantos.acmetodolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlossantos.acmetodolist.entity.Task;
import com.carlossantos.acmetodolist.repository.TaskRepository;

@Service
public class TaskService {

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> listAllTaskById(Long id){
		List<Task> allTasksForFilter = this.taskRepository.findAll();
		
		List<Task> AllFiltedTask = new ArrayList();
		
		allTasksForFilter.forEach(task -> {
			
			 if(task.getToDoList().getId() == id) {
				 AllFiltedTask.add(task);
			 }
				
		});
		
		return AllFiltedTask;
	}
	
	public Task updateTaskList(Long id, Task task) {
		Optional<Task> taskById = this.taskRepository.findById(id);
		Task taskUpdate = task;
		
		if(taskById.isPresent()) {
			Task taskForUpdate = taskById.get();
			taskForUpdate.setNameTask(taskUpdate.getNameTask());
			
			return this.taskRepository.save(taskForUpdate);
			
		}else {
			//TODO exception
			return null;
		}
	}
	
	public Task updateTaskForDone(Long id, String isDone) {
		Optional<Task> taskById = this.taskRepository.findById(id);
		String done = isDone;
		boolean bool;
		
		if(done.contains("true")) {
			bool = true;
		}else {
			bool = false;
		}
		
		if(taskById.isPresent()) {
			Task taskForUpdate = taskById.get();
			taskForUpdate.setDone(bool);
			
			return this.taskRepository.save(taskForUpdate);
			
		}else {
			//TODO exception
			return null;
		}
		
		
	}
	
	public void deleteTask(Long id) {
		Optional<Task> taskById = this.taskRepository.findById(id);
		
		if(taskById.isPresent()) {
			this.taskRepository.delete(taskById.get());
		}else {
			//TODO exception
		}
	}
	
}
