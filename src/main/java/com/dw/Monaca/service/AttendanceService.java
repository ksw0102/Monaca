package com.dw.Monaca.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Attendance;

// 출석률 관리 
public interface AttendanceService {
//	// 기능 구현 예정
//	// get 메소드, Attendance get으로 모두 가져오기
//// 출석시에 출석 사탕 생성
//	public ResponseDto<Void> createAttendance(Attendance attendance);
//
//	public ResponseDto<List<Attendance>> getAllAttendance();

	// 1. 모든 사용자의 출석 목록을 가져오기
	public ResponseDto<List<Attendance>> getAllAttendance();

	// 2. 특정 사용자의 출석 목록을 가져오기
	public ResponseDto<List<Attendance>> getAttendanceByLoginId(String loginId);

	// 3. 특정 사용자의 특정 날짜 출석을 가져오기
	public ResponseDto<List<Attendance>> getAttendanceByLoginIdAndDate(String loginId, LocalDateTime date);
}
