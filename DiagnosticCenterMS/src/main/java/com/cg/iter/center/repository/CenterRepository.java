package com.cg.iter.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.iter.center.entities.DiagnosticCentre;
@Repository
/**
 * @author Shirshak
 *
 */
public interface CenterRepository extends JpaRepository<DiagnosticCentre,String>{

	//Query for getting the CentreName from DiagnosticCentre entity by checking with Input
	@Query("select d.centreName from DiagnosticCentre d where d.centreName=?1")
	String getCentre(String centreName);
	
	//Query for getting the CentreId from DiagnosticCentre entity by checking with Input
	@Query("select d.centreId from DiagnosticCentre d where d.centreId=?1")
	String getCentreId(String centreId);
}
