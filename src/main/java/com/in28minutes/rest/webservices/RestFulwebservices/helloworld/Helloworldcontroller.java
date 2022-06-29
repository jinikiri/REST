package com.in28minutes.rest.webservices.RestFulwebservices.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class Helloworldcontroller {
	
	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello World Srikanth";
	}
	
	@GetMapping("/hello-world-bean")
	public helloWorldBean helloWorldBean()
	{
		return new helloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public helloWorldBean helloWorldBeanPathVariable(@PathVariable String name)
	{
		return new helloWorldBean(String.format("Hello World, %s", name));
	}

}
