package com.BookStor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookStor.entity.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList,Integer> {

}
