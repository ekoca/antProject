package com.virtualpairprogrammers.domain;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


/**
 * Used by our WebFlow use cases. 
 * @author Dick Chesterwood
 */
public class Order implements Serializable 
{
	private List<Book> booksOrdered;
	private Customer customer;
	private boolean giftWrap;

	public Order()
	{
		this.customer = new Customer();
	}
	
	public void removeItem(int id)
	{
		Iterator<Book> it = booksOrdered.iterator();
		while (it.hasNext())
		{
			Book next = it.next();
			if (next.getId() == id)
			{
				it.remove();
			}
		}
	}
	
	public void setBooksOrdered(List<Book> booksOrdered) {
		this.booksOrdered = booksOrdered;
	}
	public void setCustomer(Customer customerDetails) {
		this.customer = customerDetails;
	}
	
	public List<Book> getBooksOrdered() {
		return booksOrdered;
	}
	public Customer getCustomer() {
		return customer;
	}
	public boolean isGiftWrap() {
		return giftWrap;
	}
	public void setGiftWrap(boolean giftWrap) {
		this.giftWrap = giftWrap;
	}
	
	public String toString()
	{
		return "Order for " + customer.getName();
	}
	
	
}
