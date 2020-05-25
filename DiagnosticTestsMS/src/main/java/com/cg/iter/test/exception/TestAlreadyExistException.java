package com.cg.iter.test.exception;
/**
 * @author Bishal
 *
 */
public class TestAlreadyExistException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestAlreadyExistException(String msg){
	        super(msg);
	    }
	    public TestAlreadyExistException(String msg,Throwable e){
	        super(msg,e);
	    }
}
