package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.domain.Order;

public class AccountsServiceMockImpl implements AccountsService
{	
	public void raiseInvoice(Book requiredBook) 
	{
		// a very basic implementation for testing
		System.out.println("Raised the invoice for " + requiredBook);
	}

	@Override
	public Customer findCustomer(String id) throws CustomerNotFoundException {
		if (id.equals("1"))
			return new Customer("Fred Jackson");
		else throw new CustomerNotFoundException();
	}

}
