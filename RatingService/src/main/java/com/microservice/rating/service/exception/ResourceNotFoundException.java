package com.microservice.rating.service.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException()
	{
		super("This resource is not found on server.");
	}
	
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
}
