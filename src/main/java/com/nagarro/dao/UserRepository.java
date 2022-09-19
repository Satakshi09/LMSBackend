package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.UserDetails;


@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	public UserDetails findByName(String username);

	public UserDetails findByNameAndPassword(String username, String password);

}