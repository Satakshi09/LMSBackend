package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.AuthorDetails;


@Repository
public interface AuthorRepository extends JpaRepository<AuthorDetails, Long> {

}