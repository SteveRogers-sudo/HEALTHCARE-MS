package com.cg.iter.test.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.test.entities.DiagnosticCentre;
import com.cg.iter.test.entities.Test;
import com.cg.iter.test.exception.NoTestAvailableException;
import com.cg.iter.test.exception.TestAlreadyExistException;
import com.cg.iter.test.exception.TestNotFoundException;
import com.cg.iter.test.service.TestService;
/**
 * @author Bishal
 *
 */
@ControllerAdvice
@RestController
@RequestMapping("/Test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {
	
	@Autowired
	TestService service;
		
/********************************************************************************************************************************************/
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody Test test) {
		service.createTest(test);	
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
/********************************************************************************************************************************************/

	@GetMapping("/findCentre")
	public ResponseEntity<List<DiagnosticCentre>> getCentres() {
		List<DiagnosticCentre> list = service.getCentres();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
/********************************************************************************************************************************************/

	@GetMapping("/find")
	public ResponseEntity<List<Test>> getTests() {
		List<Test> list = service.getTest();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
/********************************************************************************************************************************************/

	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<Boolean> deleteTestById(@PathVariable("testId") String testId) {
		service.deleteTestById(testId);
		return new ResponseEntity<Boolean>(true, new HttpHeaders(), HttpStatus.OK);
	}
/********************************************************************************************************************************************/

	@GetMapping("/getTestList/{centerId}")
	public List<Test> getTestList(@PathVariable("centerId") String centreId) {
		List<Test> diagnosticCenters = service.TestsListByCenter(centreId);
		return diagnosticCenters;
	}
/********************************************************************************************************************************************/
	
	@ExceptionHandler(TestNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Test Not Found" , code = HttpStatus.NOT_FOUND)
	public void handleTestNotFoundException() {
		
	}
	
	@ExceptionHandler(TestAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Test with this name already exists" , code = HttpStatus.NOT_FOUND)
	public void handleTestAlreadyExistException() {
		
	}
	
	@ExceptionHandler(NoTestAvailableException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "TestList is Empty" , code = HttpStatus.NOT_FOUND)
	public void handleListisEmptyException() {
		
	}
/********************************************************************************************************************************************/		
	
	
	
}
