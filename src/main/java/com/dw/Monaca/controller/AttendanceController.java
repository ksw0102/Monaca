//package com.dw.Monaca.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dw.Monaca.dto.ResponseDto;
//import com.dw.Monaca.model.Attendance;
//
//import com.dw.Monaca.service.AttendanceService;
////import jakarta.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("/api/attendance")
//@CrossOrigin(origins="http://localhost:3000",
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
//public class AttendanceController {
//
//	private final AttendanceService attendanceService;
//	
//	 @Autowired
//	    public AttendanceController(AttendanceService attendanceService) {
//	        this.attendanceService = attendanceService;
//	    }
//
//	    // 모든 사용자의 출석 목록을 가져오기
//	    @GetMapping("/all")
//	    @PreAuthorize("hasAnyRole('ADMIN')")
//	    public ResponseEntity<ResponseDto<List<Attendance>>> getAllAttendance() {
//	        return ResponseEntity.ok(attendanceService.getAllAttendance());
//	    }
//
//	    // 특정 사용자의 출석 목록을 가져오기
//	    @GetMapping("/user/{loginId}")
//	    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//	    public ResponseEntity<ResponseDto<List<Attendance>>> getAttendanceByUserId(Long userId) {
//	        return ResponseEntity.ok(attendanceService.getAttendanceByUserId(userId));
//	    }
//
//	    // 특정 사용자와 날짜에 해당하는 출석 목록을 가져오기
//	    @GetMapping("/user/{userId}/date/{date}")
//	    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//	    public ResponseEntity<ResponseDto<List<Attendance>>> getAttendanceByUserIdAndTimeStamp(Long userId, LocalDateTime date) {
//	        // 날짜 형식에 따라 변환 필요
//	        return ResponseEntity.ok(attendanceService.getAttendanceByUserIdAndTimeStamp(userId, date));
//	    }
//	    
//	    // 특정 사용자의 출석 정보 저장
//	    @PostMapping("/save/{userId}")
//	    public ResponseDto<Attendance> saveAttendance(@PathVariable Long userId) {
//	        return attendanceService.saveAttendance(userId);
//	    }
//
//}
