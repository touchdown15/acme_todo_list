package com.carlossantos.acmetodolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoListNotFoundException extends Exception{

	public ToDoListNotFoundException(Long id) {
		super(String.format("ToDo List não encontrada", id));
	}
	
}
