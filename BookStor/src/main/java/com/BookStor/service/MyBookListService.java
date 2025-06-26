package com.BookStor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStor.entity.MyBookList;
import com.BookStor.repository.MyBookRepository;



@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList bookm) {
		mybook.save(bookm);
		
	}
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteByIdd(int id) {
		mybook.deleteById(id);
		
	}
	

}
