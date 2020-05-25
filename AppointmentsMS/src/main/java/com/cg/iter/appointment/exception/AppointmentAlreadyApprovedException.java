package com.cg.iter.appointment.exception;

public class AppointmentAlreadyApprovedException extends RuntimeException {
	public AppointmentAlreadyApprovedException(String message)
	{
		super(message);
	}

}
