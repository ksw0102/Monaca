package com.dw.Monaca.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.Candy;

public interface CandyRepository extends JpaRepository<Candy, Long>{
@EntityGraph(attributePaths = "candy_point")
Optional<Attendance> findOneWithAttendancesByAttendance
	
}
