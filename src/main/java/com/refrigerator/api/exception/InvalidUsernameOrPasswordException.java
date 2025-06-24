package com.refrigerator.api.exception;

public class InvalidUsernameOrPasswordException extends RuntimeException {

	private static final long serialVersionUID = -8414455675052559438L;

	public InvalidUsernameOrPasswordException(String message) {
        super(message);
    }
}
