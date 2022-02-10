package com.rest.book.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books_details")
public class BookEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	private String bookname;
	private String authorname;
	public BookEntities(int bookid, String bookname, String authorname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.authorname = authorname;
	}
	public BookEntities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	@Override
	public String toString() {
		return "BookEntities [bookid=" + bookid + ", bookname=" + bookname + ", authorname=" + authorname + "]";
	}
	

}
