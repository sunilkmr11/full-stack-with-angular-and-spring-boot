package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {
	
	@Autowired
	private HardCodedService todoService;
	
	
	/*
	 * @GetMapping("/") public String helloWorld() { return
	 * "Hi welcome to Todo Application!!!"; }
	 */
	//GET  users/{username}/todos
	@GetMapping("users/{username}/todos")
	List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	//GET  users/{username}/todos
		@GetMapping("users/{username}/todos/{id}")
		Todo getTodos(@PathVariable String username, @PathVariable long id){
			return todoService.findById(id);
	}
	
	//DELETE  users/{username}/todos/{id}
	@DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = todoService.deleteById(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
//	5. Edit/Update a Todos
//	6. PUT  users/{username}/todos/{id}
	@PutMapping("users/{username}/todos/{id}")
		public ResponseEntity<Todo> updateTodo(
				@PathVariable String username, 
				@PathVariable long id, 
				@RequestBody Todo todo ){
				Todo todoUpdated = todoService.save(todo);
				return new ResponseEntity<Todo>(todo, HttpStatus.OK);
			
	}

//	7. Create a Todos
//	   POST users/{username}/todos/
	@PostMapping("users/{username}/todos")
	public ResponseEntity<Void> updateTodo(
			@PathVariable String username, 
			@RequestBody Todo todo ){
			Todo createdTodo = todoService.save(todo);
			
			//Location
			//CurrentResource URL
			//users/{username}/todos/{id}"
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			      .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			return ResponseEntity.created(uri).build();
    }
}
