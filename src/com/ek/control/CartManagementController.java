package com.virtualpairprogrammers.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.domain.ShoppingCart;
import com.virtualpairprogrammers.services.BookService;

/**
 * A request scoped bean which manages our shopping cart.
 * @author Dick Chesterwood
 */
@Controller
@Scope("request")
public class CartManagementController 
{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ShoppingCart cart;

	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam("id") int id)
	{
		Book requiredBook = bookService.getBookById(id);
		cart.addItem(requiredBook);
		return new ModelAndView("bookAddedToCart", "title", requiredBook.getTitle());
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart()
	{
		List<Book> allBooks = cart.getAllItems();		
		return new ModelAndView("cartContents","cart",allBooks);
	}
}
