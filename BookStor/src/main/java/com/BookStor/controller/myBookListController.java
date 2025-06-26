package com.BookStor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookStor.service.MyBookListService;

@Controller
public class myBookListController {
	
	@Autowired
	private MyBookListService mybookservice;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleted(@PathVariable("id") int id){
		mybookservice.deleteByIdd(id);
				
		//return "myBooks";
		return "redirect:/my_books";
		
	}

}
