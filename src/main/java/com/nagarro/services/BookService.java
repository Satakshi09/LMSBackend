package com.nagarro.services;
import java.util.List;
import java.util.Optional;

import com.nagarro.model.BookDetails;


public interface BookService {

	public List<BookDetails> getAllBooks();

	public Optional<BookDetails> getBookById(long bookId);

	public BookDetails getBookByCode(long bookCode);

	public BookDetails saveBook(BookDetails bookDetails);

	public void deleteBook(BookDetails existingBook);
}