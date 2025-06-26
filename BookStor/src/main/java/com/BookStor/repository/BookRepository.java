package com.BookStor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStor.entity.Book;
// ----------------------------------------------------dattatype  datatype of id

@Repository
public interface BookRepository  extends JpaRepository<Book,Integer> {
	

}
