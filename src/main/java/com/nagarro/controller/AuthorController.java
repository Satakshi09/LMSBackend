package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.constant.WebappConstant;
import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.AuthorDetails;
import com.nagarro.services.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<AuthorDetails> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	@PostMapping
	public AuthorDetails createUser(@RequestBody AuthorDetails authorDetails) {
		return this.authorService.saveAuthorDetails(authorDetails);
	}

	@PutMapping("/{id}")
	public AuthorDetails updateAuthor(@RequestBody AuthorDetails authorDetails, @PathVariable("id") long authorId) {
		AuthorDetails existingAuthor = this.authorService.getAuthorById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException(WebappConstant.AUTHORNOTFOUND + authorId));
		existingAuthor.setAuthorName(authorDetails.getAuthorName());
		return this.authorService.saveAuthorDetails(existingAuthor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<AuthorDetails> deleteAuthor(@PathVariable("id") long authorId) {
		AuthorDetails existingAuthor = this.authorService.getAuthorById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException(WebappConstant.AUTHORNOTFOUND + authorId));
		this.authorService.deleteAuthor(existingAuthor);
		return ResponseEntity.ok().build();
	}

}