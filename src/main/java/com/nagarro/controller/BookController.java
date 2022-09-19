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
import com.nagarro.model.BookDetails;
import com.nagarro.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<BookDetails> getAllBooks() {
		return this.bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public BookDetails getBookById(@PathVariable("id") long bookId) {
		return this.bookService.getBookById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException(WebappConstant.BOOKNOTFOUND + bookId));
	}

	@GetMapping("/book/{code}")
	public BookDetails getBookByCode(@PathVariable("code") long bookCode) {
		return this.bookService.getBookByCode(bookCode);
	}

	@PostMapping
	public BookDetails createBook(@RequestBody BookDetails bookDetails) {
		return this.bookService.saveBook(bookDetails);
	}

	@PutMapping("/{id}")
	public BookDetails updateBook(@RequestBody BookDetails bookDetails, @PathVariable("id") long bookId) {
		BookDetails existingBook = this.bookService.getBookById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException(WebappConstant.BOOKNOTFOUND + bookId));
		existingBook.setBookName(bookDetails.getBookName());
		existingBook.setAuthorName(bookDetails.getAuthorName());
		existingBook.setCreatedDate(bookDetails.getCreatedDate());
		return this.bookService.saveBook(existingBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BookDetails> deleteBook(@PathVariable("id") long bookId) {
		BookDetails existingBook = this.bookService.getBookById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException(WebappConstant.BOOKNOTFOUND + bookId));
		this.bookService.deleteBook(existingBook);
		return ResponseEntity.ok().build();
	}

}