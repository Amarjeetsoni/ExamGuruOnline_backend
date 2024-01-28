package com.ExamGuruOnline.customeException;

public class NoOrganizationRegistered extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoOrganizationRegistered() {
		super();
	}
	
	public NoOrganizationRegistered(String exception) {
		super(exception);
	}
	
	public NoOrganizationRegistered(String exception, Throwable cause) {
		super(exception, cause);
	}
	
	public NoOrganizationRegistered(Throwable cause) {
		super(cause);
	}

}
