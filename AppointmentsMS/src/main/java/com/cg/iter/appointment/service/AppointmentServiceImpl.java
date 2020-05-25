package com.cg.iter.appointment.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.appointment.entities.Appointment;
import com.cg.iter.appointment.entities.DiagnosticCentre;
import com.cg.iter.appointment.entities.Test;
import com.cg.iter.appointment.exception.AppointmentAlreadyApprovedException;
import com.cg.iter.appointment.exception.AppointmentNotFoundException;
import com.cg.iter.appointment.repositories.AppointmentRepository;
import com.cg.iter.appointment.repositories.CentreRepository;
import com.cg.iter.appointment.repositories.TestRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	CentreRepository dcrepo;
	@Autowired
	TestRepository trepo;
	@Autowired
	AppointmentRepository arepo;
	
	@Override
	public List<DiagnosticCentre> DiagnosticCenterList() {
		List<DiagnosticCentre> CenterList=dcrepo.findAll();
		return CenterList;
	}

	@Override
	public List<Test> TestsList(String centreId) {
		List<Test> testList=dcrepo.getOne(centreId).getListOfTests();
		return testList;
	}

	@Override
	public String makeAppointment(Appointment app) {
		Appointment updatedApp= arepo.save(app);
		
		return "Appointment is registered, please await for confirmation";
	}

	@Override
	public Boolean userIdFound(String userId) {
		List<String> exists=arepo.checkUserIdExists(userId);
		Boolean value=exists.isEmpty();
	return value;
	}

	@Override
	public List<Appointment> AppointmentList() {
		List<Appointment> appList=arepo.findAll(); 
		// using data jpa find all method to get the values
		return appList;
	}

	@Override
	public String approveAppointment(Appointment appointment) {
//		arepo.save(app);
		if(appointment.isApproved())
 		{
 		  throw new AppointmentAlreadyApprovedException("Appointment with Id :"+appointment.getAppointmentId()+" is Already Approved");
 		}
		appointment.setApproved(true);
 		 arepo.save(appointment);
		return "Appointment is Approved by admin";
	}
	@Override
	public Appointment getAppointment(int appointmentId) {
		if(!arepo.existsById(appointmentId)){
			throw new AppointmentNotFoundException("");
		}
		return arepo.getOne(appointmentId);
	}

	

}
