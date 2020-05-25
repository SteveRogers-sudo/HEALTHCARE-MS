package com.cg.iter.center.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.iter.center.entities.Appointment;
import com.cg.iter.center.entities.DiagnosticCentre;
import com.cg.iter.center.entities.Test;
/**
 * @author Shirshak
 *
 */
public interface CenterService {

	ResponseEntity<DiagnosticCentre> addCentre(DiagnosticCentre diagnosticCentre);
	
	String getCentre(String centreName);
	
	Boolean getDetails(String centreId);
	
	void deleteCentreById(String centreId);

	List<DiagnosticCentre> getCentres();
	
	String getCentreId(String centreId);

//	DiagnosticCentre assignTestId(String centerId, String testId);

//	DiagnosticCentre assignAppointmentId(String centerId, int appointmentId);

//	DiagnosticCentre assignTestId(String centerId, Test testId);

//	DiagnosticCentre assignAppointmentId(String centerId, Appointment appointment);


}
