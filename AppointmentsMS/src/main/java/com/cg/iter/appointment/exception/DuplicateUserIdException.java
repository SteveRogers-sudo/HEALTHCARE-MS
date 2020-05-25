package com.cg.iter.appointment.exception;

public class DuplicateUserIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DuplicateUserIdException(String msg) {
		super(msg);
	}
	public DuplicateUserIdException(String msg,Throwable e) {
		super(msg,e);
	}
}
