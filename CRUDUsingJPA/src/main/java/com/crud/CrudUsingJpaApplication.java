package com.crud;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.crud.dao.UserRepository;

@SpringBootApplication
public class CrudUsingJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudUsingJpaApplication.class, args);
		
		UserRepository userRepo = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Arnav");
		user.setCity("Delhi");
		user.setStatus("Software Developer");
		
		User user2 = new User();
		user2.setName("Pankaj");
		user2.setCity("Delhi");
		user2.setStatus("Web Developer");
		
//Save Single user
		
//		 User savedUser = userRepo.save(user);
//		 System.out.println("saved user"+savedUser);
		
		
		
//Saving MultipleUsers
        //		List<User> users = List.of(user,user2);
        //		Iterable<User> result = userRepo.saveAll(users);
        //		 
        //		result.forEach(u ->{                         
        //			System.out.println(u);
        //		});
		
		
//Update the user of id 53  -> Update k liye phle id k through data laenge phir use optional class ki help se use get() krenge & uske baad updated data ko usme set krenge.
		
        //		Optional<User> optional = userRepo.findById(53);
        //		User usr = optional.get();   //if data exist then return otherwise throw Exception
        //		
        //		usr.setName("Ankit");
        //		User result = userRepo.save(usr);
        //		System.out.println(result);
		
//how to get data
		Iterable<User> itr = userRepo.findAll();
		Iterator<User> iterator = itr.iterator();
		
		//Old way
		//		while(iterator.hasNext()) {
		//			User usr = iterator.next();
		//			System.out.println(usr);
		//		}
//------------------------------------------------		
		//newWay
		//itr.forEach(usr ->{System.out.println(usr);});
//------------------------------------------------
		
//Deleting single user
		//		userRepo.deleteById(2);
		//		System.out.println("deleted");
		
//Deleting multiple user
		
		Iterable<User> allusers = userRepo.findAll();
		allusers.forEach(uuser->System.out.println(uuser));
		userRepo.deleteAll(allusers);
	}

}
