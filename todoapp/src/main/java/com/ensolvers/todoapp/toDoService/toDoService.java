package com.ensolvers.todoapp.toDoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.ensolvers.todoapp.toDoModel.*;


import com.ensolvers.todoapp.toDoRepostory.toDoRepository;

@Service
public class toDoService implements ItoDoService {

	
	private toDoRepository toDoRepo;
	
	@Autowired
	public toDoService (toDoRepository todoRepo) {
		this.toDoRepo = todoRepo;
	}
	@Override
	public List<toDoItem> findAll(){
		return toDoRepo.findAll();
	}
	
	@Override
	public toDoItem save(toDoItem item) {
		return toDoRepo.save(item);
		
	}
	@Override
	public void delete(Long id) {
		toDoRepo.deleteById(id);		
	}
}
