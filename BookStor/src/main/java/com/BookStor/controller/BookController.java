package com.BookStor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BookStor.entity.Book;
import com.BookStor.entity.MyBookList;
import com.BookStor.service.BookService;
import com.BookStor.service.MyBookListService;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
		
	@GetMapping("/")
	public String home() {
		return "home";
				
	}
	
	@GetMapping("/book_register")
	public String bookRegister(){
		return "bookRegister";
		
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook(){
		List<Book> list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList"); page name
//		m.addObject("book",list);
		
		return new ModelAndView("bookList","book",list);
		
	}
	@PostMapping("/savei")
	public String addBook(@ModelAttribute Book b) {
		service.saved(b);
		return "redirect:/available_books";
		
	}
	
	@GetMapping("/my_books")
	public ModelAndView getMyBooks() {
		List<MyBookList> list=myBookService.getAllMyBooks();
		
		//------------------------page ,var_name frontend use,  list d-type
		return new ModelAndView("myBooks","bookmy",list);
		
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
	    Book b = service.getBookById(id);
	    
	  //  if (b != null) {
	    MyBookList mb = new MyBookList();
        mb.setId(b.getId()); // Optional: depends on your design
        mb.setName(b.getName());
        mb.setAuthor(b.getAuthor());
        mb.setPrice(b.getPrice());
        
        myBookService.saveMyBooks(mb);	
	 //   }

	    return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	
	@RequestMapping("deleteBook/{id}")
	public String deletee(@PathVariable("id") int id) {
		service.deleteBook(id);
		//return "home";
		return "redirect:/available_books";

	}
	
	

}
