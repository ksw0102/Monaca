package com.dw.Monaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.QandA;
import com.dw.Monaca.model.QandABin;

public interface QandARepository extends JpaRepository<QandA, Long>{

	static void save(QandABin qandaBin) {
		// TODO Auto-generated method stub
		
	}

}
