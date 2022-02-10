package com.rest.book.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.book.entites.BookEntities;
@Component
public class BookService {

	private static List<BookEntities> list = new ArrayList<BookEntities>();
	
	static 
	{
		/*
		 * list.add(new BookEntities(12,"Head first java", "abc")); list.add(new
		 * BookEntities(21,"java", "xyz")); list.add(new BookEntities(31,"python",
		 * "lmn"));
		 */
		
	}
	public List<BookEntities> getAllBook(){
		
		return list;
		
	}
	public BookEntities getBookById(int id) {
		return list.stream().filter(bk ->bk.getBookid()==id).findAny().get();
		
	}
	public BookEntities addBook(BookEntities book) {
		list.add(book);
		return book;
	}
	public void deleteBook(int bid) {
		
		list = list.stream().filter(book -> book.getBookid() != bid).collect(Collectors.toList());
		
	}
	public void updateBook(BookEntities book, int bookId) {
		
		list = list.stream().map(b ->{
			if(b.getBookid() == bookId) {
				b.setBookname(book.getBookname());
				b.setAuthorname(book.getAuthorname());
			}
			return b;
		}).collect(Collectors.toList());
		
	}
	
}
