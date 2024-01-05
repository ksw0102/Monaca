package com.dw.Monaca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.Candy;

public interface CandyRepository extends JpaRepository<Candy, Long>{
//@EntityGraph(attributePaths = "attendances")
//Optional<Candy> findOneWithCandyByAttendance(String attendance);
	
}
