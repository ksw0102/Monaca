package com.dw.Monaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Attendance;
import com.dw.Monaca.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.DELETE })
public class AttendanceController {

	private final AttendanceService attendanceService;

	@Autowired
	public AttendanceController(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	// 1. 모든 사용자의 출석 목록을 가져오기
	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<ResponseDto<List<Attendance>>> getAllAttendance() {
		return ResponseEntity.ok(attendanceService.getAllAttendance());
	}

	// 2. 특정 사용자의 출석 목록을 가져오기
	@GetMapping("/user/{loginId}")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<ResponseDto<List<Attendance>>> getAttendanceByLoginId(String loginId) {
		return ResponseEntity.ok(attendanceService.getAttendanceByLoginId(loginId));
	}

	// 3. 특정 사용자와 날짜에 해당하는 출석 목록을 가져오기
	@GetMapping("/user/{loginId}/date/{date}")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<ResponseDto<List<Attendance>>> getAttendanceByLoginIdAndDate(String loginId,
			LocalDateTime date) {
		// 날짜 형식에 따라 변환 필요
		return ResponseEntity.ok(attendanceService.getAttendanceByLoginIdAndDate(loginId, date));
	}
}