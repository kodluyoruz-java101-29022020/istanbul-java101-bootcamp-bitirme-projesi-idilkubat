package com.java.last.project;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.last.project.model.Authors;
import com.java.last.project.model.Book;
import com.java.last.project.service.AuthorService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class BookControllerIT {
	
	@Autowired
    private TestRestTemplate restTemplate;	//REST Service leri çağırabilmek için
	
	@LocalServerPort	//atadığım rastgele pportu dependency injection sayesinde alırım
	private int tomcatPortNo;	
	
	@Autowired
	private AuthorService authorService;

	
	@Test
	@Order(1)
	public void findBookById() {
		

		String url = prepareBookRestServiceRootUrl() + "/search/id?bookId=2";

		ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);

		Book book = response.getBody();

		Assert.assertTrue(2 == book.getBookId());

	}

	
	@Test
	@Order(2)
	public void saveBook() {
		
		String url = prepareBookRestServiceRootUrl() + "/save";
		
		Book book = new Book();
		book.setBookName("TestBook1");
		book.setAuthors(authorService.findByAuthorId(1));
		book.setBookNote("Book Test Note1");
	
		
		ResponseEntity<Book> response = restTemplate.postForEntity(url, book, Book.class);

		Assert.assertTrue(response.getBody().getBookId() != null);
		
	}
	
	@Test
	@Order(3)
	public void searchByBookName() {
		// kitap adına göre veritabanında arama yapan rest api testi yazıldı

		String url = prepareBookRestServiceRootUrl() + "/search?bookName=idil";

		ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);

		Assert.assertTrue(response.getBody().length > 0);

	}
	
	@Test
	@Order(4)
	public void deleteByBookId() {

		String url = prepareBookRestServiceRootUrl() + "/delete?bookId=2";

		ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);

		Assert.assertTrue(response.getBody().length > 0);

	}
	
	private String prepareBookRestServiceRootUrl() {	
		
		return "http://localhost:" + tomcatPortNo + "/api/book/";
	}

}
