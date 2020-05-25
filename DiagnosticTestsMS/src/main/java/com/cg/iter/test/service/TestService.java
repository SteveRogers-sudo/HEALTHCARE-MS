package com.cg.iter.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.iter.test.entities.DiagnosticCentre;
import com.cg.iter.test.entities.Test;
import com.cg.iter.test.exception.TestNotFoundException;
/**
 * @author Bishal
 *
 */
@Service
public interface TestService {

	List<DiagnosticCentre> getCentres();

	List<Test> getTest();

	void saveCenter(DiagnosticCentre centre);
	
	void deleteTestById(String testId) throws TestNotFoundException;

	Test createTest(Test test);

	List<Test> TestsListByCenter(String centreId);

}
