package com.dw.Monaca.jwtauthority.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.jwtauthority.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(attributePaths = "authorities")
	Optional<User> findOneWithAuthoritiesByLoginId(String loginId);

//	User findByLoginId(String login_Id);

	@EntityGraph(attributePaths = "lectures")
	Optional<User> findOneWithLecturesByLoginId(String loginId);

	@EntityGraph(attributePaths = "wishLecture")
	Optional<User> findOneWithWishlistByLoginId(String loginId);

	User findByLoginId(String loginId);
	
	User findByLoginId(User user);

}
