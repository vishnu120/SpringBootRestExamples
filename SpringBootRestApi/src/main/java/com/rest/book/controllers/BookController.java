package com.rest.book.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.book.entites.BookEntities;
import com.rest.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bs;
// RequestEntity is responsible to send data with status code
	@GetMapping("/books")
	public ResponseEntity<List<BookEntities> > getBooks() {
		System.out.println("hello books");
		List <BookEntities> list = bs.getAllBook();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookEntities> getBooks(@PathVariable("id") int id) {
		BookEntities book = bs.getBookById(id);
             if(book == null) {
            	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
             }
             
             return ResponseEntity.of(Optional.of(book));
		
	}

	@PostMapping("/addBook")
	public ResponseEntity addBooks(@RequestBody BookEntities book) {
		BookEntities books = null;
		try {
			books = this.bs.addBook(book);
			return ResponseEntity.of(Optional.of(books));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	// delete the book with bookid
	@DeleteMapping("/books/{bookid}")
	public void deleteBook(@PathVariable ("bookid") int bookid) {
		this.bs.deleteBook(bookid);
		 
		
	}

	@PutMapping("/updateBook/{bid}")
	public BookEntities updateBooks(@RequestBody BookEntities book,@PathVariable ("bid") int bookid) {
		this.bs.updateBook(book, bookid);
		return book;
	}

}
