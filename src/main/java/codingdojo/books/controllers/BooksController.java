package codingdojo.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import codingdojo.books.models.Book;
import codingdojo.books.services.BookService;

@SpringBootApplication

@Controller

public class BooksController {
	
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
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "books/new.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) 
	{
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, 
						BindingResult result,
						@PathVariable("id") Long id,
						@RequestParam(value="title") String title,
						@RequestParam(value="description") String desc,
						@RequestParam(value="language") String lang,
						@RequestParam(value="numberOfPages") Integer numPages)
	{
		if (result.hasErrors()) {
			return "/books/edit.jsp";
		}	else {
		
			book = bookService.updateBook(id, title, desc, lang, numPages);
			return "redirect:/books";
			
		}
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteMovie(id);
		return "redirect:/books";
	}
	
}
