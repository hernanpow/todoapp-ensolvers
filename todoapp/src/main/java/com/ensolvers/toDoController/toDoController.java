package com.ensolvers.toDoController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.toDoModel.toDoItem;
import com.ensolvers.toDoService.toDoService;


//	front-end			java-server
//	HttpRequest ----> Controller ---> Service ----> Repository
//	frontend	 <---- Controller<----Service <-----

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/item")
public class toDoController {

	@Autowired
	private toDoService toDoService;
	private static final Log LOG = LogFactory.getLog(toDoItem.class);
	
	@Autowired
	public toDoController (toDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	
	
	//fetch all todo items (from database)
	@GetMapping(value ="/get")
	public ResponseEntity<Object> fetchAlltoDoItems(){
		LOG.info( "METHOD : fetchALL toDoList");
		List<toDoItem> todoItems =	new ArrayList<toDoItem>();
		try {
			todoItems = toDoService.findAll();
			LOG.info("METHOD : fetchAlltoDoItems() ****RETURN ***** "+ todoItems.toString());
		}catch ( Exception e ) {
			LOG.error("ERROR: "+ e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Erorr in fetchAlltoDoItems",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(todoItems,HttpStatus.OK);
	//	ResponseEntity.ok(todoItems); its the same, just a little bit lazier.
	
	}
	@PostMapping(value ="/save")
	public ResponseEntity<Object> save (@RequestBody toDoItem item) {
		LOG.info("METHOD : save toDoItem");
		toDoItem newItem = new toDoItem();
		try {
			newItem = toDoService.save(item);
			LOG.info("METHOD : save(item) ***** RETURN ***** " + newItem.toString());
			
		}catch ( Exception e) {
			LOG.error("ERROR : "+ e.getMessage() );
			e.printStackTrace();
			return new ResponseEntity<>("Error in save", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(newItem, HttpStatus.OK);
		
	}
	
	@PostMapping (value = "/delete")
	public ResponseEntity<Object> delete (@RequestParam ("id") Long id){
		LOG.info("METHOD: DELETE TODO");
		try {
			toDoService.delete(id);
			LOG.info("METHOD: delete ***RETURN** id eliminado "+ id);
		}catch(Exception e) {
			LOG.error("ERROR : "+ e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Error in delete", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("Eliminado",HttpStatus.OK);
	}
	
	@PostMapping (value = "/edit")
	public ResponseEntity<Object> edit (@RequestBody toDoItem item){
		LOG.info("METHOD : edit item");
		toDoItem editItem = new toDoItem();
		try {
			editItem = toDoService.save(item);
			LOG.info("METHOD edit **** RETURN **** "+ editItem.toString());
		}catch(Exception e) {
			LOG.error("ERROR : "+e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(editItem,HttpStatus.OK);
		}
		return new ResponseEntity<>("Edit completed" , HttpStatus.OK);
	}
	
	
}
