package com.ensolvers.toDoRepostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensolvers.toDoModel.toDoItem;

@Repository
public interface toDoRepository extends JpaRepository<toDoItem,Long> {	
}
