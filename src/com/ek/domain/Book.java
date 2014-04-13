package com.virtualpairprogrammers.domain;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;

import com.virtualpairprogrammers.validation.ISBN;

/**
 * Represents a Book from our Domain.
 * @author Dick Chesterwood.
 */
public class Book implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private static int nextId = 1;
	private int id;
	
	@NotEmpty
	@ISBN
	private String isbn;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String author;
	
	@Digits(integer=3, fraction=2)
	private double price;

	public Book(String isbn, String title, String author, double price) 
	{
		this.id = nextId++;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		return this.title + " by " + this.author;
	}

	public String getIsbn() 
	{
		return this.isbn;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public String getAuthor() 
	{
		return author;
	}

	public double getPrice() 
	{
		return price;
	}

	public int getId() 
	{
		return this.id;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	
}
