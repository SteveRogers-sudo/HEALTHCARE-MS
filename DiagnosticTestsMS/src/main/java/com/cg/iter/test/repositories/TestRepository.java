package com.cg.iter.test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.test.entities.Test;
/**
 * @author Bishal
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Test, String>{

	Optional<Test> findBycentreNameAndTestName(String centreName, String testName);
	
	void deleteBytestId(String testId);

}
