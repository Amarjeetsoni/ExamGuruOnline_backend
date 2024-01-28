package com.ExamGuruOnline.customeException;

public class NoUserFound extends Exception{

	private static final long serialVersionUID = 1L;

	public NoUserFound() {
		super();
	}
	
	public NoUserFound(String exception) {
		super(exception);
	}
	
	public NoUserFound(String exception, Throwable cause) {
		super(exception, cause);
	}
	
	public NoUserFound(Throwable cause) {
		super(cause);
	}
}
