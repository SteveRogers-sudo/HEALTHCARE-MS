package com.cg.iter.center.exception;

/**
 * @author Shirshak
 *
 */

public class RecordFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2997758968815479356L;

	public RecordFoundException(String message, Throwable e) {
		super(message, e);
	}

	public RecordFoundException(String message) {
		super(message);
	}

}
