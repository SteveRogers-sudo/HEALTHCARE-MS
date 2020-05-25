package com.cg.iter.appointment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.appointment.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, String> {

}
