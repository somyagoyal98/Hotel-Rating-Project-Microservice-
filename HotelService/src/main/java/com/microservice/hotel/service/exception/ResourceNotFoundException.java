package com.microservice.hotel.service.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException()
	{
		super("Resouce not found on server!!");
	}
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
}
