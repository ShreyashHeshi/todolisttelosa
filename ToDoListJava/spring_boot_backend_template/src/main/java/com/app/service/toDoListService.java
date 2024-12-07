package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Tasks;
import com.app.repositary.toDoListRepo;

@Service
public class toDoListService {
	
	
	private  toDoListRepo repo;

    public toDoListService(toDoListRepo repo) {
        this.repo = repo;
    }

    public List<Tasks> getAllTasks() {
        return repo.findAll();
    }

    public Optional<Tasks> getTaskById(Long id) {
        return repo.findById(id);
    }

    public Tasks createTask(Tasks task) {
        return repo.save(task);
    }

    public Tasks updateTask(Long id, Tasks updatedTask) {
        return repo.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setStatus(updatedTask.getStatus());
                    task.setStartDate(updatedTask.getStartDate());
                    task.setEndDate(updatedTask.getEndDate());
                    return repo.save(task);
                })
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
	
	

}
