package com.cg.iter.appointment.repositories;

import org.springframework.stereotype.Repository;

import com.cg.iter.appointment.entities.DiagnosticCentre;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CentreRepository extends JpaRepository<DiagnosticCentre, String>{

}
