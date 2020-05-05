package com.java.last.project;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.java.last.project.controller.BookApiController;
import com.java.last.project.model.Book;
import com.java.last.project.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerMT {
	
	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookApiController bookController;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void getAllBookList() {

		Book book = new Book();
		book.setBookId(1L);
		book.setBookName("idil");

		
		List<Book> bookList = Arrays.asList(book);

	
		Mockito.when(bookService.getAll())
				
				.thenReturn(bookList);

		List<Book> booksList = bookController.searchBook();
		
		Assert.assertNotNull(booksList);

	}
}
