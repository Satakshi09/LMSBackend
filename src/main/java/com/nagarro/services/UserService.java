package com.nagarro.services;
import java.util.List;
import java.util.Optional;

import com.nagarro.model.UserDetails;

public interface UserService {
	
	public List<UserDetails> getAllUsers();
	
	public Optional<UserDetails> getUserById(long bookId);
	
	public UserDetails saveUser(UserDetails userDetails);
	
	public UserDetails getUserByName(String userName);
	
	public UserDetails findByNameAndPassword(String userName, String userPassword);

}