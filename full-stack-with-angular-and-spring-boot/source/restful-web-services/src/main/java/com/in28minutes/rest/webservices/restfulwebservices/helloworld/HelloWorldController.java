package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

//GET
//URI - /hello-world
//METHOD- "Hello World"
//	@RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	@GetMapping( path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping( path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Some error has occured. Please Contact System Administration...");
				return new HelloWorldBean("Hello World Bean");
	}
	
	
	//hello-world/path-variable/in28minutes
	@GetMapping( path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
