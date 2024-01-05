package com.dw.Monaca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
//	@EntityGraph(attributePaths = "users")
//	Optional<Lecture> findOneWithLecturesByUsername(String username);
//
//	@EntityGraph(attributePaths = "wishlist")
//	Optional<Lecture> findOneWithWishlistByUsername(String username);

}
