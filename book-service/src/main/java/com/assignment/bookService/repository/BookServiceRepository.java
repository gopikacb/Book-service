package com.assignment.bookService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.bookService.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookServiceRepository extends JpaRepository<Book, Long> {
	
}