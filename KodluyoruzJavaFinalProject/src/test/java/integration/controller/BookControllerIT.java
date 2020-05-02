package integration.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.last.project.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class BookControllerIT {
	
	@Autowired
    private TestRestTemplate restTemplate;	//REST Service leri çağırabilmek için
	
	@LocalServerPort	//atadığım rastgele pportu dependency injection sayesinde alırım
	private int tomcatPortNo;		
	
	@Test
	@Order(1)
	public void testRestTemplate() {	//Oluşturduğum restTemplate http üzerinden istek atabiliyor mu diye test ederiz
		
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);
		
		System.out.println(tomcatPortNo);
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(response.getBody().length() > 0);
	}
	
	@Test
	@Order(2)
	public void findByBookId() {
		
		String url = prepareBookRestServiceRootUrl() + "book/1"; //1 numaralı kayıt var mı diye bakar
		
		ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
		
		Book book = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(1 == book.getBookId());
	}
	
	@Test
	@Order(3)
	public void saveBook() {
		
		String url = prepareBookRestServiceRootUrl() + "book";
		
		Book book = new Book();
		book.setBookName("TestBook1");
		book.setBookNote("Book Test Note1");
	
		
		
		ResponseEntity<Long> response = restTemplate.postForEntity(url, book, Long.class);
		
		Long bookNo = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertNotNull(bookNo);
	}
	
	@Test
	@Order(4)
	public void getAllBookList() {
		
		String url = prepareBookRestServiceRootUrl() + "employee/profile/list?size=1";		//Bu kısım doğru değil
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("x-api-key", "BookgetAll");
		
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(httpHeaders);
		
		ResponseEntity<List<Book>> response = restTemplate.exchange(
				url, 
				HttpMethod.GET, 
				httpEntity, 
				new ParameterizedTypeReference<List<Book>>() {} );
		
		List<Book> profiles = response.getBody();
		
		Assert.assertTrue(HttpStatus.UNAUTHORIZED.equals(response.getStatusCode()));
		Assert.assertNotNull(profiles);
		Assert.assertEquals(1, profiles.size());
	}
	
	private String prepareBookRestServiceRootUrl() {	
		
		return "http://localhost:" + tomcatPortNo;
	}

}
