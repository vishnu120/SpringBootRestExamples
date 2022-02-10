package com.rest.book.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;


import com.rest.book.entites.BookEntities;

public interface BookRepository extends CrudRepository {
	
	public BookEntities findBybookid(int id);

}
