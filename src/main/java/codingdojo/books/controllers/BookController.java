package codingdojo.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import codingdojo.books.models.Book;
import codingdojo.books.services.BookService;

@SpringBootApplication

@Controller

public class BookController {
	
	@Autowired 
	BookService bookService;

	@RequestMapping("/books")
	public String index (Model model) {
	
		List<Book> allBooks = bookService.allBooks();
	
		model.addAttribute("books", allBooks);
		
		return "index.jsp";
		
	}
	
	@RequestMapping("/books/{id}")
	public String show (
						Model model,
						@PathVariable(value="id") Long id) {
	Book book = bookService.findBook(id);
	
//	System.out.println(book);
	
	model.addAttribute("book", book);
	
		
		return "show.jsp";
	}
}
