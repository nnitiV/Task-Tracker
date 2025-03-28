package com.task.tracker.tasktracker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.tracker.tasktracker.entities.Task;
import com.task.tracker.tasktracker.repositories.TaskRepository;

@Controller
@RequestMapping("/")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping
	public String home(Model model) {
		model.addAttribute("task", new Task());
		List<Task> listOfTasks = taskRepository.findAll();
		model.addAttribute("tasks", listOfTasks);
		return "home";
	}
	
	@RequestMapping("/delete_task")
	public String deleteTask( @RequestParam("task_id") Optional<Integer> taskId) {
		System.out.println("teste");
		taskRepository.deleteById(taskId.get().longValue());
		return "redirect:/";
	}

	@RequestMapping(value = "/update_task")
	public String updateTask(@ModelAttribute Task task) {
		taskRepository.save(task);
		return "redirect:/";
	}
	
	@PostMapping
	public String doPost(@ModelAttribute Task task) {
		System.out.println(task);
		taskRepository.save(task);
		return "redirect:/";
	}
}
