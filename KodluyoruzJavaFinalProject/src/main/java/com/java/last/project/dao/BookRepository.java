package com.java.last.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.last.project.model.Authors;
import com.java.last.project.model.Book;

//data ile etkileşimi olan sınıflarda kullanıyoruz  
@Repository // burada oluşan hatalar otomatik olarak Spring'in DataAccessExceptionlarına
			// dönüşebilir
public interface BookRepository extends CrudRepository<Book, Long> {
	@Query("Select book From Book book Where book.bookId = :id ") // id ye göre kitabı bulma
	public Book findByBookId(@Param("id") Long id);


	@Query("Select b From Book b Where b.bookName like '%:bookName%'") // id ye göre kitabı bulma
	public List<Book> findByBookName(@Param("bookName") String bookName);

}
