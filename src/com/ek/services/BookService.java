package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.data.BookNotFoundException;
import com.virtualpairprogrammers.domain.Book;

public interface BookService 
{
	   public List<Book> getAllBooksByAuthor(String author);
	   public List<Book> getAllRecommendedBooks(String userId);
	   public List<Book> getBookByIsbn(String isbn) throws BookNotFoundException;
	   public List<Book> getEntireCatalogue();
	   public void registerNewBook(Book newBook);
	   public Book getBookById(int id);
	   public List<Book> searchBooksByLooseMatch(String chars);
}
