package com.ExamGuruOnline.customeException;

public class UserAlreadyPresentException extends Exception{
	private static final long serialVersionUID = 1L;

	public UserAlreadyPresentException() {
		super();
	}
	
	public UserAlreadyPresentException(String exception) {
		super(exception);
	}
	
	public UserAlreadyPresentException(String exception, Throwable cause) {
		super(exception, cause);
	}
	
	public UserAlreadyPresentException(Throwable cause) {
		super(cause);
	}
}
