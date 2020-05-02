package com.java.last.project.pagecontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.last.project.model.Authors;
import com.java.last.project.model.Book;
import com.java.last.project.service.AuthorService;
import com.java.last.project.service.BookService;

@Controller
public class PageController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBook(Model model) {

		List<Book> books = bookService.getAll();
		model.addAttribute("books", books);

		System.err.println(books.size());
		System.err.println("TTTT");

		return "pages/book_list";
	}

	@RequestMapping(value = "/book/save", method = RequestMethod.GET)
	public String getBookSavePage(Book book, Model model) {
		List<Authors> author = authorService.getAll();
		model.addAttribute("author", author);

		return "pages/book_save";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String save(Book book, BindingResult result, Model model) {

		bookService.save(book);

		model.addAttribute("book", bookService.getAll());

		return "pages/book_list";
	}

}
