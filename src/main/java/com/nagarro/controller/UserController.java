package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.UserDetails;
import com.nagarro.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDetails> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@PostMapping
	public UserDetails createUser(@RequestBody UserDetails userDetails) {
		return this.userService.saveUser(userDetails);
	}

	@GetMapping("/{name}")
	public UserDetails getUserByName(@PathVariable("name") String userName) {
		return (UserDetails) this.userService.getUserByName(userName);
	}

	@GetMapping("/{name}/{password}")
	public UserDetails getUserByNameAndPassword(@PathVariable("name") String userName,
			@PathVariable("password") String userPassword) {
		return (UserDetails) this.userService.findByNameAndPassword(userName, userPassword);
	}

}