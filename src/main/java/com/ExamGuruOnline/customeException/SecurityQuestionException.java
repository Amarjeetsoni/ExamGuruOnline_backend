package com.ExamGuruOnline.customeException;

public class SecurityQuestionException extends Exception{
	private static final long serialVersionUID = 1L;

	public SecurityQuestionException() {
		super();
	}
	
	public SecurityQuestionException(String exception) {
		super(exception);
	}
	
	public SecurityQuestionException(String exception, Throwable cause) {
		super(exception, cause);
	}
	
	public SecurityQuestionException(Throwable cause) {
		super(cause);
	}
}
