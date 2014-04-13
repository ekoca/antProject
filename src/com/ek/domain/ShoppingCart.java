package com.virtualpairprogrammers.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * The cart is session scoped, which means we can access it from the HttpSession without
 * having to manually handle the session. See the Spring MVC course for full details!
 * @author Dick Chesterwood
 */
@Component
@Scope("session")
public class ShoppingCart implements Serializable
{
	private List<Book> shopping = new ArrayList<Book>();

	public void addItem(Book newItem)
	{
		this.shopping.add(newItem);
	}
	
	public List<Book> getAllItems()
	{
		return shopping;
	}
	
	public void clear() 
	{
		this.shopping.clear();
	}
}
