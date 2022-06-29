package com.in28minutes.rest.webservices.RestFulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userResource {
	
	@Autowired
	private UserDao service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		return service.findone(id);
	}
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		User saveuser=service.save(user);
		
	}
	
}
