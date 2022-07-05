package com.in28minutes.rest.webservices.RestFulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


@Component
public class UserDao {

	private static int userscount=3;
	private static List<User> users=new ArrayList<>();
	static {
		users.add(new User(1,"srikanth","12-12-2020"));
		users.add(new User(2,"Raghupathi","12-12-2020"));
		users.add(new User(3,"Mounika", "12-12-2020"));
	}
	public List<User> findAll()
	{
		return users;
	}
	public User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++userscount);
		}
		users.add(user);
		return user;
	}
	public User findone(int id)
	{
		//ds
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	public User deleteByID(@PathVariable int id)
	{
		
		//ss
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext())
		{
		User user= iterator.next();
		if(user==null)
			iterator.remove();
			return user;
		
		
		}
		return null;
	}
	

}
