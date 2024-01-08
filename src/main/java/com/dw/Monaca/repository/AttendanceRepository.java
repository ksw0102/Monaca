package com.dw.Monaca.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	// 출석 이력과 관련된 사용자 정의 추가
	@EntityGraph(attributePaths = "candies")

	// 로그인 ID를 기반으로 출석 이력을 가져오는 쿼리
//	Optional<Attendance> getAttendanceByLoginId(String loginId);

	// 특정 로그인 ID에 해당하는 모든 출석 이력을 가져오는 쿼리
	List<Attendance> findByLoginId(String loginId);

	// 특정 로그인 ID와 날짜에 해당하는 출석 이력을 가져오는 쿼리
	List<Attendance> findByLoginIdAndDate(String loginId, LocalDateTime date);
}
