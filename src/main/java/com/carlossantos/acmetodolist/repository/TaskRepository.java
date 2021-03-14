package com.carlossantos.acmetodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlossantos.acmetodolist.entity.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {

}
