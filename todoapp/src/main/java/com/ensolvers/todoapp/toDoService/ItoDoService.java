package com.ensolvers.todoapp.toDoService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensolvers.todoapp.toDoModel.toDoItem;

@Service
public interface ItoDoService {
	
	List<toDoItem> findAll();
	
	toDoItem save (toDoItem item);
	
	void delete(Long id);
	

}
