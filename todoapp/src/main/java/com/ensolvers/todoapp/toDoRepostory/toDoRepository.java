package com.ensolvers.todoapp.toDoRepostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensolvers.todoapp.toDoModel.toDoItem;

@Repository
public interface toDoRepository extends JpaRepository<toDoItem,Long> {	
}
