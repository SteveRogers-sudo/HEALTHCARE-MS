package com.cg.iter.test.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.cg.iter.test.entities.DiagnosticCentre;

/**
 * @author Bishal
 *
 */
@Component
@Entity
@Table(name = "DCentre")
public class DiagnosticCentre {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String centreId;
	
	private String centreName;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_c_id")
	private List<Test> listOfTests = new ArrayList<>();
	
	//Method to add test in to list of Tests
	public void addTest(Test test) {
		listOfTests.add(test);
        test.setDiagnosticCentre(this);
    }

	public List<Test> getListOfTests() {
		return listOfTests;
	}

	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}
	
	public DiagnosticCentre() {
	}

	public DiagnosticCentre(String centreName) {
		this.centreName = centreName;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	@Override
	public String toString() {
		return "DiagnosticCentre [centreId=" + centreId + ", centreName=" + centreName + "]";
	}

	
	
}