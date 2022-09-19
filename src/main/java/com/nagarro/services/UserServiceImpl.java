package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UserRepository;
import com.nagarro.model.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDetails> getAllUsers() {
		return this.userRepository.findAll();
	}

	public Optional<UserDetails> getUserById(long bookId) {
		return this.userRepository.findById(bookId);
	}

	public UserDetails getUserByName(String userName) {
		return this.userRepository.findByName(userName);
	}

	public UserDetails saveUser(UserDetails userDetails) {
		return this.userRepository.save(userDetails);
	}

	public UserDetails findByNameAndPassword(String userName, String userPassword) {
		return this.userRepository.findByNameAndPassword(userName, userPassword);
	}
}