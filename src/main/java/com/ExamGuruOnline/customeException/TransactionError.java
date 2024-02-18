package com.ExamGuruOnline.customeException;

public class TransactionError extends Exception{
	private static final long serialVersionUID = 1L;

	public TransactionError() {
		super();
	}
	
	public TransactionError(String exception) {
		super(exception);
	}
	
	public TransactionError(String exception, Throwable cause) {
		super(exception, cause);
	}
	
	public TransactionError(Throwable cause) {
		super(cause);
	}
}
