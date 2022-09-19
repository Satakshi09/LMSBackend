package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import com.nagarro.model.AuthorDetails;

public interface AuthorService {

	public List<AuthorDetails> getAllAuthors();
	
	public AuthorDetails saveAuthorDetails(AuthorDetails authorDetails);
	
	public void deleteAuthor(AuthorDetails existingAuthor);
	
	public Optional<AuthorDetails> getAuthorById(long authorId);
	
}