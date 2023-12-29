package com.dw.Monaca.jwtauthority.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.jwtauthority.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
