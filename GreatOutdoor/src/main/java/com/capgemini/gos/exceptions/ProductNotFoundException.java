package com.capgemini.gos.exceptions;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException(String message)
	{
		super(message);
	}
	public ProductNotFoundException()
	{
		super();
	}

}