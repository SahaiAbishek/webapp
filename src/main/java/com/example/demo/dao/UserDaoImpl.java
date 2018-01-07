package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
@Qualifier("userDao")
public class UserDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addUser(User user) {
		jdbcTemplate.update("INSERT INTO user (user_id, first_name, Last_name) VALUES (?, ?, ?)",
	            1, user.getProvFirstName(), user.getProvLastName());
		
		System.out.println("user added successfully");
	}

}
