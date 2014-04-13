package com.virtualpairprogrammers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ISBNValidator implements ConstraintValidator<ISBN, String> 
{
	@Override
	public void initialize(ISBN arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean isValid(String raw, ConstraintValidatorContext arg1) 
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
