package com.virtualpairprogrammers.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.data.BookNotFoundException;
import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.services.BookService;

/**
 * This is a a console application to test the wiring etc of our beans. It isn't intended to replace
 * the "real" front end!
 * @author Dick Chesterwood
 */
public class SpringClient 
{
	public static void main(String[] args)
	{
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext("application.xml");		
		BookService books = (BookService)factory.getBean("bookService");
		
		// recommended books for this course!
		books.registerNewBook(new Book("1933988134", "Spring in Action", "Craig Walls", 23.99));
		books.registerNewBook(new Book("0764543857", "Expert One-on-one J2EE Design and Development", "Rod Johnson", 28.59));

		// show the entire catalogue
		System.out.println("Here's our entire catalougue:\n");
		List<Book> allBooks = books.getEntireCatalogue();
		for (Book next : allBooks)
		{
			System.out.println(next);
		}
		
		// find a particular book
		System.out.println("\nNow searching for a particular book:");
		List<Book> requiredBooks;
		try 
		{
			requiredBooks = books.getBookByIsbn("1933988134");
			System.out.println("Found the books: " + requiredBooks);
		} 
		catch (BookNotFoundException e) 
		{
			System.out.println("I really am most awfully sorry - that book doesn't exist.");
		}
		
		// find all books by Rod Johnson
		System.out.println("\nAll books by Rod Johnson....");
		List<Book> rodsBooks = books.getAllBooksByAuthor("Rod Johnson");
		for (Book next: rodsBooks)
		{
			System.out.println(next);
		}
		
		factory.close();
	}
}
