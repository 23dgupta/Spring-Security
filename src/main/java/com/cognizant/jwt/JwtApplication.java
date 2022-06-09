package com.cognizant.jwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.jwt.entity.User;
import com.cognizant.jwt.repository.UserRepository;

@SpringBootApplication
public class JwtApplication {
	
	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void initUsers() {
		
		
		List<User> users=Stream.of(new User(101,"anup","anup","anup@gmail.com"),
				
				new User(102,"Durgesh","Durgesh","dkg@gmail.com"),
				new User(103,"Admin","Admin","admin@gmail.com"),
				new User(104,"sbnm","sbnm","sbnm@gmail.com"),
				new User(105,"sam","sam","sam@gmail.com")
				
				
				).collect(Collectors.toList());
		
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
	
	
	

}
