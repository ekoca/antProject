package com.virtualpairprogrammers.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.domain.Order;
import com.virtualpairprogrammers.services.AccountsService;
import com.virtualpairprogrammers.services.CustomerNotFoundException;

/**
 * This class is used by our Spring WebFlow XML.
 * @author Dick Chesterwood
 */
@Component
public class OrderFlowActions  
{
	@Autowired
	private AccountsService accounts;
	
	public Customer findCustomer(String id) throws CustomerNotFoundException
	{
			Customer requiredCustomer = accounts.findCustomer(id);
			return requiredCustomer;

	}
}
