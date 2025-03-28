package com.task.tracker.tasktracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.tracker.tasktracker.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> getTaskByTaskName(String taskName);
}
