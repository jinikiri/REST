package com.in28minutes.rest.webservices.RestFulwebservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		//ss
		User user= service.findone(id);
		if(user==null)
		{
			throw new UserNotFoundException("id-->"+id);
		}
		return user;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		
		User saveuser=service.save(user);
		
		URI location= ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(saveuser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	@DeleteMapping("/srikanth/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user=service.deleteByID(id);
		if(user==null)
		{
			throw new UserNotFoundException("id-->"+id);

		}
	}
	
}
