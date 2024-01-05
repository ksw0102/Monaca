package com.dw.Monaca.jwtauthority.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.jwtauthority.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
