package com.java.last.project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.last.project.dao.BookRepository;
import com.java.last.project.model.Book;
import com.java.last.project.service.AuthorService;
import com.java.last.project.service.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceMT {
	
	@Mock
	private BookRepository bookRepository;
	@InjectMocks
	private BookServiceImpl bookServiceImpl;
	@Autowired
	private AuthorService authorService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveBook() {
		
		Book book = new Book();
		book.setBookName("Book name mock test");
		book.setAuthors(authorService.findByAuthorId(1));
		book.setBookNote("Book test book note");

		Mockito.when(bookRepository.save(book)).thenReturn(book);

		Book book2 = new Book();
		book2.setBookName("Book name mock test2");
		book2.setAuthors(authorService.findByAuthorId(2));
		book2.setBookNote("Book test book note2");


		Book resultBook = bookServiceImpl.save(book2);

		Assert.assertNotNull(resultBook);
	}
	
	private void findBookByBookId() {
		
		Book book = new Book();
		book.setBookId(1L);
		book.setBookName("idil");
	   
		 
	    Mockito
	    	.when(bookRepository.findByBookId(1L))
	    	.thenReturn(book);
		
	}
	

}
