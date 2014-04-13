package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.domain.Order;

public interface AccountsService 
{
	public void raiseInvoice(Book requiredBook);
	
	public Customer findCustomer(String id) throws CustomerNotFoundException;
}
