package codingdojo.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import codingdojo.books.models.Book;
import codingdojo.books.repositories.BookRepository;

@Service

public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();	
		}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
		
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	Optional<Book> optionalBook = bookRepository.findById(id);
	if(optionalBook.isPresent()) {
		Book book = optionalBook.get();
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		
		return bookRepository.save(book);
	} else {
		return null;
	}
	
	}
						
	
	public void deleteMovie(Long id) {
		bookRepository.deleteById(id);
	}
	


}
