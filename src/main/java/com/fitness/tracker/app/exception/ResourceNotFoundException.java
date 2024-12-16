package com.fitness.tracker.app.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String resource, Long id) {
		super(resource + " with ID " + id + " not found.");
	}

	public ResourceNotFoundException(String resource, String field, String value) {
		super(resource + " with " + field + " = " + value + " not found.");
	}

}
