package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class HardCodedService {

	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter,  "Learn to Dance", new Date(), true));
		todos.add(new Todo(++idCounter, "Learn to Sing a song", new Date(),true));
		todos.add(new Todo(++idCounter, "Learn to Play Guitar", new Date(), true));
	}
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId() == 0) {      //to Create a new Todo
			todo.setId(++idCounter);
			todos.add(todo);
		}else {                                     // TO Update Todo
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	public Todo deleteById(long id) {
		boolean isRemoveId = false;
		Todo todo = findById(id); 
		if(todo==null) {
			return null;
		}
		//isRemoveId=todos.remove(todo);
		System.out.println("isRemoveId: "+isRemoveId);
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}
	
	public Todo findById(long id) {
		for(Todo todo: todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
}
 