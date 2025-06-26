package com.BookStor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Table(name="MyBooks")
@Data
public class MyBookList {
	
	
	

	@Id
	
	private int id;
	private String name;
	private String author;
	private String price;

}
