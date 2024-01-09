//package com.dw.Monaca.service.impl;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.dw.Monaca.dto.ResponseDto;
//import com.dw.Monaca.enumStatus.ResultCode;
//import com.dw.Monaca.exception.InvalidRequestException;
//import com.dw.Monaca.jwtauthority.model.User;
//import com.dw.Monaca.jwtauthority.repository.UserRepository;
//import com.dw.Monaca.model.Attendance;
//import com.dw.Monaca.repository.AttendanceRepository;
//import com.dw.Monaca.service.AttendanceService;
//
//import jakarta.transaction.Transactional;
//
//@Service
//@Transactional
//public class AttendanceServiceImpl implements AttendanceService{
//
//	private final AttendanceRepository attendanceRepository;
//	private final UserRepository userRepository;
//
//@Autowired
//public AttendanceServiceImpl(AttendanceRepository attendanceRepository, UserRepository userRepository) {
//	super();
//	this.attendanceRepository = attendanceRepository;
//	this.userRepository = userRepository;
//}
//
//
////모든 출석 이력을 가져오기
//@Override
//public ResponseDto<List<Attendance>> getAllAttendance() {
//    // 출석 이력을 리포지토리에서 모두 가져오기
//    List<Attendance> attendances = attendanceRepository.findAll();
//    // 만약 출석 이력이 비어 있다면, 예외를 발생.
//    if (attendances.isEmpty()) {
//        throw new InvalidRequestException("Attendance empty", "출석 이력이 존재하지 않습니다.");
//    }
// // 출석 이력이 비어 있지 않다면, 성공적인 응답을 생성하여 반환.
//    return new ResponseDto<>(ResultCode.SUCCESS.name(), attendances, ResultCode.SUCCESS.getMsg());
//}
//
//
//// 사용자 ID를 기반으로 출석 정보를 리포지토리에서 가져오기
//@Override
//public ResponseDto<List<Attendance>> getAttendanceByUserId(String userId) {
//    List<Attendance> attendances = attendanceRepository.findByUserId(UserId);
//// 리스트가 비어 있는지 확인하고 그에 따라 처리
//if (attendances.isEmpty()) {
//    throw new InvalidRequestException("Attendance not found", "해당 사용자의 출석 이력이 없습니다.");
//}
//// 성공 코드와 출석 목록을 포함한 응답을 반환
//return new ResponseDto<>(ResultCode.SUCCESS.name(), attendances, ResultCode.SUCCESS.getMsg());
//}
//
//
//@Override
//public ResponseDto<List<Attendance>> getAttendanceByUserIdAndTimeStamp(Long userId, LocalDateTime timeStamp) {
//    // 사용자 ID와 날짜로 출석 목록을 가져오기
//	List<Attendance> attendances = attendanceRepository.findByUserIdAndTimeStamp(userId, timeStamp);
//	
//	 return new ResponseDto<>(ResultCode.SUCCESS.name(), attendances, ResultCode.SUCCESS.getMsg());
//}
//
//@Override
//public ResponseDto<Attendance> saveAttendance(Long userId) {
//    // 사용자 ID로 사용자를 조회
//    User user = userRepository.findById(Id);
//    		if (user == null) {
//                throw new InvalidRequestException("User not found", "해당 ID의 사용자를 찾을 수 없습니다.");
//            }
//
//    // 현재 시간을 기준으로 출석 정보 생성
//    LocalDateTime currentTime = LocalDateTime.now();
//    Attendance attendance = new Attendance(null, user, currentTime);
//
//    // 생성된 출석 정보 저장
//    Attendance savedAttendance = attendanceRepository.save(attendance);
//
//    // 저장된 출석 정보를 응답
//    return new ResponseDto<>(ResultCode.SUCCESS.name(), savedAttendance, ResultCode.SUCCESS.getMsg());
//}
//}
