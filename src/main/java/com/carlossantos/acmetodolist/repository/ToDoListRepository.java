package com.carlossantos.acmetodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlossantos.acmetodolist.entity.ToDoList;

public interface ToDoListRepository extends JpaRepository <ToDoList, Long>  {

}
