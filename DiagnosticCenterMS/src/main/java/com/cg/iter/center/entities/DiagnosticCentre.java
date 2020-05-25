package com.cg.iter.center.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Shirshak
 *
 */
@Entity
@Table(name = "DCentre")
public class DiagnosticCentre {
	
	@Id
	private String centreId;
	
	private String centreName;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_c_id")
	private List<Test> listOfTests = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_c_id")
	private List<Appointment> appointmentList = new ArrayList<>();

	public void addTest(Test test) {
		listOfTests.add(test);
        test.setDiagnosticCentre(this);
    }
	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public List<Test> getListOfTests() {
		return listOfTests;
	}

	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
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


}
