package com.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Tasks;

@Repository
public interface toDoListRepo extends JpaRepository<Tasks, Long>{

}
