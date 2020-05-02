package integration.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.last.project.dao.BookRepository;
import com.java.last.project.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BookRepositoryIT {
	
	@Autowired
	private BookRepository bookRepository;
	
/*	@Test
	@Order(1)
	public void selectAllBookProfileList() {
		
		List<Book> bookProfileList = (List<Book>) bookRepository.findAll();
		
		Assert.assertEquals(bookProfileList.size(), 1);
	}
	*/
	
	@Test
	@Transactional
	@Rollback(true)
	@Order(2)
	public void saveBook() {
		
		
		Book book = new Book();
		book.setBookId(1L);
		book.setBookName("Test Book Repository");
		book.setBookNote("Test Book Note");
		
		bookRepository.save(book);

		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBookId() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(3)
	public void updateEmployee() {
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(4)
	public void deleteEmployee() {
		
	}

}
