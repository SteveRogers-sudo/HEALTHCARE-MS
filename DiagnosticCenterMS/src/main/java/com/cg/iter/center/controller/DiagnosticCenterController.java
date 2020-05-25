package com.cg.iter.center.controller;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.center.entities.DiagnosticCentre;
import com.cg.iter.center.exception.RecordFoundException;
import com.cg.iter.center.exception.RecordNotFoundException;
import com.cg.iter.center.service.CenterService;

/**
 * @author Shirshak
 *
 */
@RestController
@RequestMapping("/DiagnosticCentre")
@CrossOrigin(origins = "http://localhost:4200")
public class DiagnosticCenterController {

	private String centreName;
	private Boolean data;
	
	private static final Logger logger = Logger.getLogger(DiagnosticCenterController.class);
	
	@Autowired
	CenterService service;
	
/***************************************************************************************************************************************/
	
	@PostMapping("/create")
	public ResponseEntity<DiagnosticCentre> create(@RequestBody(required=false) DiagnosticCentre diagnosticCentre) {
		return service.addCentre(diagnosticCentre);
	}
	
/***************************************************************************************************************************************/
	
	@DeleteMapping("/delete/{centreId}")
	public ResponseEntity<Boolean> deleteCentreById(@PathVariable("centreId") String centreId) {
		if(centreId==null){
            throw new RuntimeException("Centre id is null");
        }
		data = service.getDetails(centreId);
		if (Boolean.TRUE.equals(data)) {
			service.deleteCentreById(centreId);
			return new ResponseEntity<>(true, new HttpHeaders(), HttpStatus.OK);
		} else;
			throw new RecordNotFoundException("Centre Name found");
	}
	
/***************************************************************************************************************************************/	
	@GetMapping("/find")
	public ResponseEntity<List<DiagnosticCentre>> getCentres() {
		List<DiagnosticCentre> list = service.getCentres();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
/***************************************************************************************************************************************/

	@ExceptionHandler(RecordFoundException.class)
	public ResponseEntity<Boolean> userNotFound(RecordFoundException e) {
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
	
/***************************************************************************************************************************************/
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> userNotFound(RecordNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
//*******************************
//	@PutMapping("/assign-testid/{centerId}/test-id/{testId}")
//	public DiagnosticCentre assignTestId(@PathVariable String centerId,@PathVariable String testId)
//	{
//		return service.assignTestId(centerId, testId);
//	}
//******************************
//	@PutMapping("/assign-appointmentid/{centerId}/appointment-id/{appointmentId}")
//	public DiagnosticCentre assignAppointment(@PathVariable String centerId,@PathVariable int appointmentId)
//	{
//		return service.assignAppointmentId(centerId, appointmentId);
//	}
	
}
