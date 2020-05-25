package com.cg.iter.center.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Shirshak
 *
 */
@Entity
@Table(name = "Test")
public class Test {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String testId;
	
	private String testName;
	
	@ManyToOne
	private DiagnosticCentre centre;
//	DiagnosticCentre centre = new DiagnosticCentre();
	
	private String centreName;
	
	public String getCentreName() {
		return centreName; // = centre.getCentreName();
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	
	public void setDiagnosticCentre(DiagnosticCentre diagnosticCentre) {
		this.centre = diagnosticCentre;
	}
	
	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + "]";
	}
	
}
