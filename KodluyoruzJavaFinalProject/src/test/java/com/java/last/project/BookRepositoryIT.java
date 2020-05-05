package com.java.last.project;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.last.project.dao.BookRepository;
import com.java.last.project.model.Book;
import com.java.last.project.service.AuthorService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application.properties"})
public class BookRepositoryIT {
	
	@Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    
    @Test
    @Order(1)
    public void saveBook() {

        Book book = new Book();
        book.setAuthors(authorService.findByAuthorId(1));
        book.setBookName("Book repository IT name");
        book.setBookNote("Book repository IT note");

        Book resultBook = bookRepository.save(book);

        Assert.assertNotNull(resultBook);

    }
    
    @Test
    @Order(2)
    public void searchBookById() {
        Book book = bookRepository.findByBookId(1L);
        Assert.assertNotNull(book);
    }

    @Test
    @Order(3)
    public void searchBookByName() {
        List<Book> book = bookRepository.findByBookName("idil");
        Assert.assertTrue(book.size() > 0);
    }
    
    @Test
    @Order(4)
    public void deleteByBookId() {
    	
    	List<Book> book = (List<Book>) bookRepository.findAll();
    	int bookSize = book.size();
    	
    	bookRepository.deleteById(1L);
    	int testSize = book.size();
        Assert.assertTrue(testSize == bookSize -1);
    	
    
    }

	
	
}
