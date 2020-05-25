package com.cg.iter.test.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.test.entities.DiagnosticCentre;
import com.cg.iter.test.entities.Test;
import com.cg.iter.test.exception.NoTestAvailableException;
import com.cg.iter.test.exception.TestAlreadyExistException;
import com.cg.iter.test.exception.TestNotFoundException;
import com.cg.iter.test.repositories.DiagnosticCentreRepository;
import com.cg.iter.test.repositories.TestRepository;
/**
 * @author Bishal
 *
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testrepo;
	
	@Autowired
	DiagnosticCentreRepository centerrepo;
	
	private Random rand = new Random();
	private static final Logger logger = Logger.getLogger(TestServiceImpl.class);

/*******************************************************************************************************************************************************************
	METHOD - createTest
		   - Creates Test after getting the required details !
		   @param Test
		   @return Test
		   @throws TestAlreadyExistException
		   
*******************************************************************************************************************************************************************/

	@Override
	public Test createTest(Test test) {
		
		String testId;
		
		//generating random integer for testId
		testId = Integer.toString(rand.nextInt(1000));   
		//setting TestId for test
		test.setTestId(testId);
		
		Test test1 = null;
		
		DiagnosticCentre diagnosticcentre = centerrepo.findByCentreName(test.getCentre().getCentreName());
		
		if (diagnosticcentre != null) {
			
			Optional<Test> testFound = testrepo.findBycentreNameAndTestName(diagnosticcentre.getCentreName(), test.getTestName());
			if (testFound.isPresent()) 
			{
				throw new TestAlreadyExistException("TestName Already Exists");
			}
			test1 = new Test(test.getTestName(), diagnosticcentre);
		} 
		else {	
			DiagnosticCentre centre = new DiagnosticCentre(test.getCentre().getCentreName());
			centerrepo.save(centre);
			
			test1 = new Test(test.getTestName(), centre);
			test1.setTestId(testId);

			centre.addTest(test1);
		}
		return	testrepo.save(test1);
	}
	
/*******************************************************************************************************************************************************************
	METHOD - getCentres
		   - Fetches all the Diagnostic Centers from the database !
		   * @return List<DiagnosticCentre>

*******************************************************************************************************************************************************************/
	
	@Override
	public List<DiagnosticCentre> getCentres() {
		return centerrepo.findAll();
	}
	
/*******************************************************************************************************************************************************************
	METHOD - getTest
		   - Fetches all the Diagnostic Tests from the database !
		   * @return List<Test>
		   * @throws NoTestAvailableException 
		   
*******************************************************************************************************************************************************************/
	
	@Override
	public List<Test> getTest() {
		if(testrepo.findAll().isEmpty()) {
			throw new NoTestAvailableException("Test List is empty");
		}
		return testrepo.findAll();
	}
	
/*******************************************************************************************************************************************************************
	METHOD - saveCenter
		   - Saves the given Diagnostic Center to the database !
		   @param DiagnosticCentre centre
		   
*******************************************************************************************************************************************************************/

	@Override
	public void saveCenter(DiagnosticCentre centre) {
		centerrepo.save(centre);
		
	}
	
/*******************************************************************************************************************************************************************
	METHOD - deleteTestById
		   - Removes the Diagnostic Center from the database by given TestId !
 			* @param String testId
 			* @throws TestNotFoundException 
 	
*******************************************************************************************************************************************************************/
	@Override
	public void deleteTestById(String testId) {
		if(!testrepo.existsById(testId)) {
			logger.error("Null requests, Test does not exist");

			throw new TestNotFoundException("["+testId+"] is Not Found"); 
		}
		else
		testrepo.deleteById(testId);
		
	}

/*******************************************************************************************************************************************************************
	METHOD - TestsList
		   - Fetches the Diagnostic Tests from the database by given  !
		   @param String centerId
		   @return List<Test>
		   
*******************************************************************************************************************************************************************/
	
	@Override
	public List<Test> TestsListByCenter(String centerId) {
		List<Test> testList=centerrepo.getOne(centerId).getListOfTests();
		return testList;
	}
	
/******************************************************************************************************************************************************************/
}
	

