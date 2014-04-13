package com.virtualpairprogrammers.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.services.BookService;

/**
 * Controls all use cases related to the management of books (except for the creation of books, 
 * which is handled by the CreateBookController. 
 * @author cybrandian
 * @see CreateBookController
 */
@Controller
public class BookManagementController 
{	
	@Autowired
	private BookService bookService;

	@RequestMapping("/viewAllBooksPDF")
	public ModelAndView viewAllBooksPDF()
	{
		List<Book> allBooks = bookService.getEntireCatalogue();
		return new ModelAndView("bookReportPdf","allBooks",allBooks);
	}	
	
	@RequestMapping("/viewAllBooksExcel")
	public ModelAndView viewAllBooksExcel()
	{
		List<Book> allBooks = bookService.getEntireCatalogue();
		return new ModelAndView("bookReportExcel","allBooks",allBooks);
	}	
	
	@RequestMapping("/viewAllBooks")
	public ModelAndView viewAllBooks()
	{
		List<Book> allBooks = bookService.getEntireCatalogue();
		return new ModelAndView("displayAllBooks","allBooks",allBooks);
	}
	
	@RequestMapping("/findByAuthor")
	public ModelAndView findByAuthor(@RequestParam("AUTHOR")String author)
	{
		List<Book> books = bookService.getAllBooksByAuthor(author);
		return new ModelAndView("displayAllBooks", "allBooks", books);
	}
	
	@RequestMapping("/looseSearch")
	public @ResponseBody List<Book> performLooseSearch(@RequestParam("CHARS")String chars)
	{
		if (chars.length() < 3)
			return null;
		
		return bookService.searchBooksByLooseMatch(chars);
	}
}
