package com.nagarro.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.BookDetails;

@Repository
public interface BookRepository extends JpaRepository<BookDetails, Long> {

	BookDetails findByBookCode(long bookCode);
}