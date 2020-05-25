package com.cg.iter.appointment.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.cg.iter.appointment.entities.Test;


@Entity
@Table(name = "Appointment_table")
public class Appointment{
	
	@Id
	@GeneratedValue
	@Column(length=10)
	private int appointmentId;
	@Column(length=20)
	private Date datetime;
	@Column(length=10)
	private boolean approved;
	@Column(length=10)
	private String userId;
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Test_centre_id")
//	private String test;
	
	@Column(length=30)
	private String center;
	
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDateTimeSlot() {
		return datetime;
	}
	public void setDateTimeSlot(Date dateTimeSlot) {
		this.datetime = dateTimeSlot;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
//	public String getTest() {
//		return test;
//	}
//	public void setTest(String test) {
//		this.test = test;
//	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
//	@Override
//	public String toString() {
//		return "appointmentId=" + appointmentId + ", dateTimeSlot=" + datetime + ", approved="
//				+ approved + ", userId=" + userId + ", test=" + test + ", center=" + center + "]";
//	}
	
	

}