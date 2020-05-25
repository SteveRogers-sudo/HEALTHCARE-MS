package com.cg.iter.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bishal
 *
 */
@Entity
@Table(name = "Test")
public class Test {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "TestId")
	private String testId;
	
	@Column(name = "TestName")
	private String testName;

	@ManyToOne
	@JoinColumn(name = "centre_id")
	private DiagnosticCentre centre;

	private String centreName;


	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public Test() {

	}
	public DiagnosticCentre getCentre() {
		return centre;
	}

	public void setCentre(DiagnosticCentre centre) {
		this.centre = centre;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Test(String testName,DiagnosticCentre centreName) {
		super();
		this.testName = testName;
		this.centre = centreName;      //
		this.centreName = centreName.getCentreName();
	}
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", testName=" + testName + ", centre=" + centre + ", centreName="
				+ centreName + "]";
	}
//
	public void setDiagnosticCentre(DiagnosticCentre diagnosticCentre) {
		this.centre = diagnosticCentre;

		
	}

}