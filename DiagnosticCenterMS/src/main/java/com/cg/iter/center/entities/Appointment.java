package com.cg.iter.center.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Shirshak
 *
 */
@Entity
@Table(name = "Appointment")
public class Appointment{
	
	@Id
	@GeneratedValue
	private int appointmentId;

	private String dateTimeSlot;

	private boolean approved;

	private String userId;

	private String test;

	private String center;
	
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getDateTimeSlot() {
		return dateTimeSlot;
	}
	public void setDateTimeSlot(String dateTimeSlot) {
		this.dateTimeSlot = dateTimeSlot;
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
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "appointmentId=" + appointmentId + ", dateTimeSlot=" + dateTimeSlot + ", approved="
				+ approved + ", userId=" + userId + ", test=" + test + ", center=" + center + "]";
	}
	
	

}
