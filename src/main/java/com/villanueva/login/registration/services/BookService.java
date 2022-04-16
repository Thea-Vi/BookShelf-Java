package com.villanueva.login.registration.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.villanueva.login.registration.models.Book;
import com.villanueva.login.registration.respositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

//	CREATE BOOK
	public Book createBook(Book book) {
		return this.bookRepository.save(book);
	}

}
