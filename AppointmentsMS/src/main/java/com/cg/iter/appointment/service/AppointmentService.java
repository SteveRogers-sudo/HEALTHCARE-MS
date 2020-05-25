package com.cg.iter.appointment.service;

import java.util.List;
import java.util.Set;

import com.cg.iter.appointment.entities.Appointment;
import com.cg.iter.appointment.entities.DiagnosticCentre;
import com.cg.iter.appointment.entities.Test;

public interface AppointmentService {
	
	List<DiagnosticCentre> DiagnosticCenterList();
	
	List<Test> TestsList(String centreId);
	
	String makeAppointment(Appointment app);
    
	Boolean userIdFound(String userId);

	List<Appointment> AppointmentList();

	String approveAppointment(Appointment appointment);

	Appointment getAppointment(int appointmentId);
}
