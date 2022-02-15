package com.rest.book.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.book.dao.BookRepository;
import com.rest.book.entites.BookEntities;

@Component
public class BookService {
	@Autowired
	private BookRepository bookrepository;

	/*
	 * private static List<BookEntities> list = new ArrayList<BookEntities>();
	 * 
	 * static {
	 * 
	 * list.add(new BookEntities(12,"Head first java", "abc")); list.add(new
	 * BookEntities(21,"java", "xyz")); list.add(new BookEntities(31,"python",
	 * "lmn"));
	 * 
	 * 
	 * }
	 */
	public List<BookEntities> getAllBook() {

		List<BookEntities> list = (List<BookEntities>) this.bookrepository.findAll();
		return list;

	}

	public BookEntities getBookById(int id) {
		BookEntities book = null;
		book = this.bookrepository.findBybookid(id);
		return book;
	}

	public BookEntities addBook(BookEntities book) {

		BookEntities result = bookrepository.save(book);
		return result;
	}

	public void deleteBook(int bid) {

		bookrepository.deleteById(bid);

	}

	public void updateBook(BookEntities book, int bookId) {
		book.setBookid(bookId);
		bookrepository.save(book);

	}

}
