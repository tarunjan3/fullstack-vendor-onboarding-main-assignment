package com.example.vendor.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Generic custom exception handler for all, where we will delete anything based
	 * on the id
	 * 
	 */

	public ResourceNotFoundException(String resourceName, Object resourceId) {
		super(String.format("%s with id '%s' not found", resourceName, resourceId));
	}

}
