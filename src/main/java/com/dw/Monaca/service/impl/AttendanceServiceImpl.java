package com.dw.Monaca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.model.Attendance;
import com.dw.Monaca.repository.AttendanceRepository;
import com.dw.Monaca.service.AttendanceService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	private final AttendanceRepository attendanceRepository;

	@Autowired
	public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
		this.attendanceRepository = attendanceRepository;
	}

//	Override 어노테이션의 역할 : 서브클래스의 메소드가 수퍼클래스의 메소드를 오버라이드하거나 인터페이스에서 선언된 메소드를 구현하기 위해 사용, 
//    @Override를 사용하면 컴파일러가 어노테이션이 달린 메소드가 정말로 수퍼클래스나 인터페이스의 메소드를 오버라이드하고 있는지 확인,
//   일치하는 메소드가 없거나 메소드 시그니처에 오류가 있는 경우 컴파일러는 오류를 생성
	@Override
	public ResponseDto<List<Attendance>> getAllAttendance() {
		// 출석 이력을 리포지토리에서 모두 가져오기
		List<Attendance> attendances = attendanceRepository.findAll();
		// 만약 출석 이력이 비어 있다면, 예외를 발생.
		if (attendances.isEmpty()) {
			throw new InvalidRequestException("Attendance empty", "출석 이력이 존재하지 않습니다.");
		}
		// 출석 이력이 비어 있지 않다면, 성공적인 응답을 생성하여 반환.
		return new ResponseDto<>(ResultCode.SUCCESS.name(), attendances, ResultCode.SUCCESS.getMsg());
	}

// 사용자 ID를 기반으로 출석 정보를 리포지토리에서 가져오기
	@Override
	public ResponseDto<List<Attendance>> getAttendanceByLoginId(String loginId) {
		List<Attendance> attendances = attendanceRepository.findByLoginId(loginId);
// 리스트가 비어 있는지 확인하고 그에 따라 처리
		if (attendances.isEmpty()) {
			throw new InvalidRequestException("Attendance not found", "해당 사용자의 출석 이력이 없습니다.");
		}
// 성공 코드와 출석 목록을 포함한 응답을 반환
		return new ResponseDto<>(ResultCode.SUCCESS.name(), attendances, ResultCode.SUCCESS.getMsg());
	}

	@Override
	public ResponseDto<List<Attendance>> getAttendanceByLoginIdAndDate(String loginId, LocalDateTime date) {
		// 사용자 ID와 날짜로 출석 목록을 가져오기
		List<Attendance> attendances = attendanceRepository.findByLoginIdAndDate(loginId, date);

		return new ResponseDto<>(ResultCode.SUCCESS.name(), attendances, ResultCode.SUCCESS.getMsg());
	}
}
