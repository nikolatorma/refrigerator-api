package com.refrigerator.api.exception;

public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1043508043831628525L;

	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
