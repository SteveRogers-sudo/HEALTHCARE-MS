package com.cg.iter.center.exception;
/**
 * @author Shirshak
 *
 */

public class RecordNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 9208362352695292444L;

	public RecordNotFoundException(String msg){
        super(msg);
    }

    public RecordNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
