package com.virtualpairprogrammers.domain;

import junit.framework.TestCase;

/**
 * Not production standard, these tests are here to demonstrate test running from Ant.
 * @author Dick Chesterwood
 */
public class BookTest extends TestCase 
{
	public void testBooksWithTheSameIsbnAreConsideredEqual()
	{
		// arrange
		Book bookOne = new Book ("032133678X", "Java Puzzlers", "Josh Bloch, Neal Gafter", 20.00);
		Book bookTwo = new Book ("032133678X", "Java Puzzlers", "Josh Bloch, Neal Gafter", 20.00);
		
		// act
		boolean areTheyEqual = bookOne.equals(bookTwo);
		
		// assert
		assertTrue(areTheyEqual);
	}
	
	public void testConvertingToString()
	{
		// arrange
		Book book = new Book ("032133678X", "Java Puzzlers", "Josh Bloch, Neal Gafter", 20.00);
		
		// act
		String result = book.toString();
		
		// assert
		String expectedResult = "Java Puzzlers by Josh Bloch, Neal Gafter";
		assertEquals(expectedResult, result);
	}
}
