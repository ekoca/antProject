package com.virtualpairprogrammers.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.virtualpairprogrammers.domain.Book;

@Component
public class BookValidator implements Validator
{
	public boolean supports(Class<?> clazz) 
	{
		return clazz.equals(Book.class);
	}

	public void validate(Object actualObject, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");	
		
		Book book = (Book)actualObject;
		String isbn = book.getIsbn();
		
		if (!isValidIsbn(isbn))
		{
			errors.rejectValue("isbn", "invalidisbn");
		}
	}
	
	// note - not industrial strength implementation!
	public boolean isValidIsbn(String raw)
	{
		if (raw.length() != 10) {
			return false;
		}
		int total = 0;
		for (int i = 0; i < 9; i++) {
			char c = raw.charAt(i);
			int digit = Character.digit(c, 10);
			total += (10 - i) * digit;
		}
		int checksum = Character.digit(raw.charAt(9), 10);
		if (checksum == -1 && raw.charAt(9) == 'X')
		{
			checksum = 10;
		}		
		int modulo = total % 11;
		return modulo == 11 - checksum;
	}
}
