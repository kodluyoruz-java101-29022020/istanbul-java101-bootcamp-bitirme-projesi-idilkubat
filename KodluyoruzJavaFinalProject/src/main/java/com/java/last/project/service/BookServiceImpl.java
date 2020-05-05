package com.java.last.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.java.last.project.annotion.MethodRunningTime;
import com.java.last.project.dao.BookRepository;
import com.java.last.project.model.Book;

@Service // iş akışlarını yazdığımız kısım
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional
	public Book save(Book book) {
		// TODO Auto-generated method stub
			return bookRepository.save(book);
	}

	@MethodRunningTime(active = true)
	@Override
	@Transactional // rollbackFor
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	// @MethodRunningTime(active = true)
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepository.findAll();
	}

	@MethodRunningTime(active = true)
	@Override
	public List<Book> findByBookName(String bookName) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookName(bookName);
	}

	@Override
	@Transactional
	public void delete(Long bookId) {
		// TODO Auto-generated method stub
		if(bookRepository.findByBookId(bookId)!= null) {
			bookRepository.deleteById(bookId);
		}
	}

	@Override
	public Book findByBookId(Long bookId) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookId(bookId);
	}



}
