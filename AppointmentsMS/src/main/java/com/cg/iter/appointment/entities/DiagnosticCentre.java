package com.cg.iter.appointment.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "diagnostic_centre")
public class DiagnosticCentre {
	@Id
//	@Column(length=10)
	private String centreId;
	private String centreName;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_c_id")
	private List<Test> listOfTests = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_c_id")
	private List<Appointment> appointmentList = new ArrayList<>();

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

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "DiagnosticCentre [centreId=" + centreId + ", centreName=" + centreName + ", listOfTests=" + listOfTests
				+ ", appointmentList=" + appointmentList + "]";
	}
	public DiagnosticCentre() {
		
	}
	

}

