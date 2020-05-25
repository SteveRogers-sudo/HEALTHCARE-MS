package com.cg.iter.appointment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.iter.appointment.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	@Query("select m.userId from Appointment m where m.userId=?1")
	public List<String> checkUserIdExists(String userId);

}
