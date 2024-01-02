package com.dw.Monaca.jwtauthority.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dw.Monaca.jwtauthority.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(attributePaths = "authorities")
	Optional<User> findOneWithAuthoritiesByUsername(String username);

	@Query("SELECT u FROM User u JOIN FETCH u.authorities WHERE u.username = :username")
	Optional<User> findAuthoritiesByUsername(@Param("username") String username);

	User findByUsername(String loginId);

}
