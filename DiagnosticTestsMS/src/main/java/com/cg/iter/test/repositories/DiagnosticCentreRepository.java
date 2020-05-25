package com.cg.iter.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.test.entities.DiagnosticCentre;
/**
 * @author Bishal
 *
 */
@Repository
public interface DiagnosticCentreRepository extends JpaRepository<DiagnosticCentre, String> {
	
	DiagnosticCentre findByCentreName(String centreName);

}
