package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.BookRepository;
import com.nagarro.model.BookDetails;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<BookDetails> getAllBooks() {
		return this.bookRepository.findAll();
	}

	public Optional<BookDetails> getBookById(long bookId) {
		return this.bookRepository.findById(bookId);
	}

	public BookDetails getBookByCode(long bookCode) {
		return this.bookRepository.findByBookCode(bookCode);
	}

	public BookDetails saveBook(BookDetails bookDetails) {
		return this.bookRepository.save(bookDetails);
	}

	public void deleteBook(BookDetails existingBook) {
		this.bookRepository.delete(existingBook);
	}

}