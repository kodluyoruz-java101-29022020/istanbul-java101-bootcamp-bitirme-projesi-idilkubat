package com.java.last.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.java.last.project.model.Book;

@Service
public interface BookService {
	
	public void save(Book book);
	public void update(Book book);
	public void delete(Long bookId);
	public List<Book> getAll();
	public List<Book> findByBookName(String book);
	public Book findByBookId(Long bookId);

}
