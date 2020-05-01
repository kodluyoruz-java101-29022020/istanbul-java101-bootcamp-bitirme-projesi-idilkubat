package com.java.last.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.last.project.model.Book;
import com.java.last.project.service.BookService;

@Controller
@RequestMapping("/jsp/controller/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/api/book/list", method = RequestMethod.GET)
	public List<Book> getAll() {
		
		return bookService.getAll();
		
	}

}
