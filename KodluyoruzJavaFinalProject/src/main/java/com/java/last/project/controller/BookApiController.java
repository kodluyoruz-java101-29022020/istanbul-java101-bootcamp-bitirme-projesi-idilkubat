package com.java.last.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.last.project.model.Book;
import com.java.last.project.service.BookService;

@RestController
public class BookApiController {  
	//kitap ara(tum kayıtlar - kitapadına gore ) - sil -güncelle-kaydet işlemleri olacak
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/api/book/save" ,  method = RequestMethod.POST)
	public void saveBook(@RequestBody Book book) {
		bookService.save(book);
	}
	
	@RequestMapping(value="/api/book/update" ,  method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book book) {
		bookService.update(book);
	}
	
	@RequestMapping(value="/api/book/delete" ,  method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable Long bookId) {
		bookService.delete(bookId);
	}
	
	@RequestMapping(value="/api/book/search" ,  method = RequestMethod.GET)
	public List<Book> searchBook(@PathVariable String bookName){
		
		return bookService.findByBookName(bookName);
	}
	
	@RequestMapping(value="/api/book/search/all" ,  method = RequestMethod.GET)
	public List<Book> searchBook(){
		
		return bookService.getAll();
	}
	
	
	

}
