package com.assignment.bookService.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.bookService.model.Book;
import com.assignment.bookService.model.dto.BookStatusDTO;
import com.assignment.bookService.repository.BookServiceRepository;
import com.assignment.bookService.service.BookService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class BookServiceController {

	@Autowired
	private BookServiceRepository bookServiceRepository;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getUserDetails() {
		return bookServiceRepository.findAll();
	}

    // 2. Get book by ID
    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    // 3. Add a new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    // 4. Update book details
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(bookId, book));
    }

    // 5. Delete a book
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    // 6. Search books by various criteria
    @GetMapping("/books/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(bookService.searchBooks(params));
    }

    // 7. Get availability status
    @GetMapping("/books/{bookId}/availability")
    public ResponseEntity<Boolean> getBookStatus(@PathVariable Long bookId) {
    	System.out.print("Status: "+bookService.getBookStatus(bookId));
    	return ResponseEntity.ok(bookService.getBookStatus(bookId));
    }

//     8. Update book status
//    @PutMapping("/books/{bookId}/status")
//    public ResponseEntity<Void> updateBookStatus(@PathVariable Long bookId, @RequestBody Boolean status) {
//        bookService.updateBookStatus(bookId, status);
//        return ResponseEntity.noContent().build();
//    }
	
    
    @PutMapping("/books/{bookId}/status")
    public ResponseEntity<String> updateBookStatus(@PathVariable Long bookId,
                                              @RequestBody BookStatusDTO bookStatus) {
        
        bookService.updateBookStatus(bookId, bookStatus.getStatus());
        return ResponseEntity.ok("Updated Successfully");
    }
}
