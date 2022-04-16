package com.villanueva.login.registration.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.villanueva.login.registration.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();

}
