package com.assignment.bookService.service;

import com.assignment.bookService.model.Book;
import com.assignment.bookService.repository.BookServiceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import com.assignment.bookService.exception.ResourceNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookServiceRepository bookServiceRepository;
    
    @Autowired
    private EntityManager entityManager;

    // Get all books
    public List<Book> getAllBooks() {
        return bookServiceRepository.findAll();
    }
    
    // Get a book by ID
    public Book getBookById(Long id) {
        return bookServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "ID", id));
    }

    // Add a new book
    public Book addBook(Book book) {
        book.setCreatedAt(new Date());
        book.setUpdatedAt(new Date());
        return bookServiceRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Long id, Book updatedBook) {
        Book existing = getBookById(id); // Fetch the existing book or throw if not found

        // Update fields
        existing.setTitle(updatedBook.getTitle());
        existing.setIsbn(updatedBook.getIsbn());
        existing.setAuthors(updatedBook.getAuthors());
        existing.setPublisher(updatedBook.getPublisher());
        existing.setPublicationDate(updatedBook.getPublicationDate());
        existing.setGenre(updatedBook.getGenre());
        existing.setDescription(updatedBook.getDescription());
        existing.setNoOfBooks(updatedBook.getNoOfBooks());
        existing.setUpdatedAt(new Date()); // Update timestamp

        // Save and return updated book
        return bookServiceRepository.save(existing);
    }

    // Delete a book
    public void deleteBook(Long id) {
        Book book = getBookById(id); // Check if book exists
        bookServiceRepository.delete(book);
    }

    // Get book status
    public Boolean getBookStatus(Long id) {
    	if(getBookById(id).getNoOfBooks() > 0) {
    		return true;
    	}
        return false;
    }

    // Update book status
    public void updateBookStatus(Long id, String status) {
        Book book = getBookById(id);
        if(StringUtils.equals(status, "BORROWED")) {
            book.setNoOfBooks(book.getNoOfBooks() - 1);
        }else if(StringUtils.equals(status, "AVAILABLE")) {
            book.setNoOfBooks(book.getNoOfBooks() + 1);
        }
        book.setUpdatedAt(new Date()); // Update timestamp
        bookServiceRepository.save(book);
    }

    public List<Book> searchBooks(Map<String, String> params) {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> book = query.from(Book.class);

        List<Predicate> predicates = new ArrayList<>();

        params.forEach((key, value) -> {
            if (key.equalsIgnoreCase("title")) {
                predicates.add(cb.like(cb.lower(book.get("title")), "%" + value.toLowerCase() + "%"));
            } else if (key.equalsIgnoreCase("author")) {
                predicates.add(cb.like(cb.lower(book.get("author")), "%" + value.toLowerCase() + "%"));
            } else if (key.equalsIgnoreCase("genre")) {
                predicates.add(cb.equal(book.get("genre"), value));
            } else if (key.equalsIgnoreCase("year")) {
                predicates.add(cb.equal(book.get("year"), Integer.valueOf(value)));
            }
        });

        query.select(book).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
