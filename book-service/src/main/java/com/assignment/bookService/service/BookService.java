package com.assignment.bookService.service;

import com.assignment.bookService.model.Book;
import com.assignment.bookService.repository.BookServiceRepository;
import com.assignment.bookService.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookServiceRepository bookServiceRepository;

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
        existing.setStatus(updatedBook.getStatus());
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
    public String getBookStatus(Long id) {
        return getBookById(id).getStatus();
    }

    // Update book status
    public void updateBookStatus(Long id, String status) {
        Book book = getBookById(id);
        book.setStatus(status);
        book.setUpdatedAt(new Date()); // Update timestamp
        bookServiceRepository.save(book);
    }

    // Search books by various criteria (placeholder, can be implemented further)
    public List<Book> searchBooks(Map<String, String> params) {
        // Implement search logic (e.g., using JPA Specification or custom query)
        throw new UnsupportedOperationException("Search not yet implemented");
    }
}
