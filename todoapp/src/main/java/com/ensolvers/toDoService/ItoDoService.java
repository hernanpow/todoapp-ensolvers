package com.ensolvers.toDoService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensolvers.toDoModel.toDoItem;

@Service
public interface ItoDoService {
	
	List<toDoItem> findAll();
	
	toDoItem save (toDoItem item);
	
	void delete(Long id);
	

}
