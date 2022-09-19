package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.AuthorRepository;
import com.nagarro.model.AuthorDetails;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<AuthorDetails> getAllAuthors() {
		return this.authorRepository.findAll();
	}

	public AuthorDetails saveAuthorDetails(AuthorDetails authorDetails) {
		return this.authorRepository.save(authorDetails);
	}

	public void deleteAuthor(AuthorDetails existingAuthor) {
		this.authorRepository.delete(existingAuthor);
	}

	public Optional<AuthorDetails> getAuthorById(long authorId) {
		return this.authorRepository.findById(authorId);
	}

}