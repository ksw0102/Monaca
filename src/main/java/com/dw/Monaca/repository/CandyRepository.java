package com.dw.Monaca.repository;


//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.Candy;

public interface CandyRepository extends JpaRepository<Candy, Long>{

//	Optional<Candy> findById(Long Id);

	
}
