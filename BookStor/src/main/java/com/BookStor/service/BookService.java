package com.BookStor.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BookStor.entity.Book;
import com.BookStor.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	
	
	public void saved(Book b) {
		bRepo.save(b);
		
	}
	
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	
	
	public void deleteBook(int id) {
		
		bRepo.deleteById(id);
	}
	

}
