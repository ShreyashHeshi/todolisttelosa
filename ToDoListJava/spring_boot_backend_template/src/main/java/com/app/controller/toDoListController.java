package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Tasks;
import com.app.service.toDoListService;

@RestController
@RequestMapping("/api/tasks")
public class toDoListController {
	
	 private toDoListService  service;

	    public toDoListController(toDoListService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Tasks> getAllTasks() {
	        return service.getAllTasks();
	    }

	    @GetMapping("/{id}")
	    public Optional<Tasks> getTaskById(@PathVariable Long id) {
	        return service.getTaskById(id);
	    }

	    @PostMapping
	    public Tasks createTask(@RequestBody Tasks task) {
	        return service.createTask(task);
	    }

	    @PutMapping("/{id}")
	    public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks updatedTask) {
	        return service.updateTask(id, updatedTask);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteTask(@PathVariable Long id) {
	        service.deleteTask(id);
	    }
	

}
