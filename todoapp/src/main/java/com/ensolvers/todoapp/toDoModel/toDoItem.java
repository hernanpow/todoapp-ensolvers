package com.ensolvers.todoapp.toDoModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;




@Entity 
@Table (name = "toDO")
public class toDoItem {

	//Long stores (2^63)-1 in real life is better
	//Integer stores (2^32)-1 in this case, is okey Integer.
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false , columnDefinition = "TEXT")
	private String task;
	
	@Column(columnDefinition = "BOOLEAN")
	@ColumnDefault ("false")
	private Boolean isDone;
	
	public toDoItem() {
		
	}
	
	
	public toDoItem(Long id, String task, Boolean isMarked) {
		this.id = id;
		this.task = task;
		this.isDone = isMarked;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
