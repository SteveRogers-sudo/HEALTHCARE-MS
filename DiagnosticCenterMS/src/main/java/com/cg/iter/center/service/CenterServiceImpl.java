package com.cg.iter.center.service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.iter.center.entities.Appointment;
import com.cg.iter.center.entities.DiagnosticCentre;
import com.cg.iter.center.entities.Test;
import com.cg.iter.center.exception.RecordFoundException;
import com.cg.iter.center.repository.CenterRepository;
/**
 * @author Shirshak
 *
 */
@Service
@Transactional
public class CenterServiceImpl implements CenterService {
   @Autowired
	CenterRepository repo;
	
   private String centreName;
	private Boolean data;
   private Random rand = new Random();
   private String centreId;
   
	@Override
	public ResponseEntity<DiagnosticCentre> addCentre(DiagnosticCentre diagnosticCentre) {
		
		if(diagnosticCentre==null){
            throw new RuntimeException("Diagnostic Centre is null");
        }
		centreId=Integer.toString(rand.nextInt(1000));
		centreName = repo.getCentre(diagnosticCentre.getCentreName());
		//	centreId = "CEN"+repo.count(); 
		diagnosticCentre.setCentreId(centreId);
		
		//Adding default Tests to new Diagnostic centers as mentioned in Document
//		Test test1 = new Test();
//		test1.setTestId("bg");
//		test1.setTestName("Blood Group");
//		test1.setCentreName(centreName);
//		Test test2 = new Test();
//		test2.setTestId("bs");
//		test2.setTestName("Blood Sugar");
//		test2.setCentreName(centreName);
//		Test test3 = new Test();
//		test3.setTestId("bp");
//		test3.setTestName("Blood Pressure");
//		test3.setCentreName(centreName);
//
//		diagnosticCentre.addTest(test1);
//		diagnosticCentre.addTest(test2);
//		diagnosticCentre.addTest(test3);
		///////////////////////////////
		
		
		if (centreName != null) {
			throw new RecordFoundException("Centre Name found");
		} else {
			repo.save(diagnosticCentre);
			return new ResponseEntity<DiagnosticCentre>(diagnosticCentre, HttpStatus.OK);
		}
	}

	@Override
	public String getCentre(String centreName) {
		return repo.getCentre(centreName);

	}

	@Override
	public void deleteCentreById(String centreId) {
		repo.deleteById(centreId);;//JpaRepository method for deleting using centreId
		
	}

	@Override
	public List<DiagnosticCentre> getCentres() {
		return repo.findAll();
	}

	@Override
	public Boolean getDetails(String centreId) {
		return repo.existsById(centreId);
	}

	@Override
	public String getCentreId(String centreId) {
		return repo.getCentreId(centreId);

	}
	/////////////
//	@Override
//	public DiagnosticCentre assignTestId(String centerId, Test test) {
//		
//		DiagnosticCentre center=repo.getOne(centerId);
//		
//		center.getListOfTests().add(test);
//		
//		return repo.save(center);
//	}
	/////////////////
//	@Override
//	public DiagnosticCentre assignAppointmentId(String centerId, Appointment appointment) {
//		
//		DiagnosticCentre center=repo.getOne(centerId);
//		
//		center.getAppointmentList().add(appointment);
//		
//		return repo.save(center);
//	}

}
