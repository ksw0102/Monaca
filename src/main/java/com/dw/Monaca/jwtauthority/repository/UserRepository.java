package com.dw.Monaca.jwtauthority.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.jwtauthority.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(attributePaths = "authorities")
	Optional<User> findOneWithAuthoritiesByName(String name);

	User findByName(String login_Id);

	@EntityGraph(attributePaths = "lectures")
	Optional<User> findOneWithLecturesByName(String name);

	@EntityGraph(attributePaths = "wish_lecture")
	Optional<User> findOneWithWishlistByName(String name);

}
