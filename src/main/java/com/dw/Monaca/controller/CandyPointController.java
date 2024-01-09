//package com.dw.Monaca.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.dw.Monaca.dto.CandyPointDto;
//import com.dw.Monaca.model.CandyPoint;
//import com.dw.Monaca.service.CandyPointService;
//
//public class CandyPointController {
//
//	 private final CandyPointService candyPointService;
//
//	    @Autowired
//	    public CandyPointController(CandyPointService candyPointService) {
//	        this.candyPointService = candyPointService;
//	    }
//
//	    // CandyPoint 생성 API
//	    @PostMapping("/candyPoint")
//	    public ResponseEntity<CandyPoint> createCandyPoint(@RequestBody CandyPointDto candyPointDto) {
//	        CandyPoint candyPoint = candyPointService.createCandyPoint(
//	                candyPointDto.getAttendanceId(),
//	                candyPointDto.getCandyId(),
//	                candyPointDto.getExaminationId(),
//	                candyPointDto.getItemShopId(),
//	                candyPointDto.getUseHistory(),
//	                candyPointDto.getDescription()
//	        );
//	        return new ResponseEntity<>(candyPoint, HttpStatus.CREATED);
//	    }
//
//	    // CandyPoint 삭제 API
//	    @DeleteMapping("/delete/{candyPointId}")
//	    public ResponseEntity<String> deleteCandyPoint(@PathVariable Long candyPointId) {
//	        candyPointService.deleteCandyPoint(candyPointId);
//	        return new ResponseEntity<>("CandyPoint 삭제 성공", HttpStatus.OK);
//	    }
//
//	    // 특정 사용자의 CandyPoint 기록 조회 API
//	    @GetMapping("/userCandyHistory/{userId}")
//	    public ResponseEntity<List<CandyPoint>> getUserCandyPointHistory(@PathVariable Long userId) {
//	        List<CandyPoint> candyPoints = candyPointService.getUserCandyPointHistory(userId);
//	        return new ResponseEntity<>(candyPoints, HttpStatus.OK);
//	    }
//
//	    // 모든 사용자의 CandyPoint 기록 조회 API
//	    @GetMapping("/CandyPointHistory")
//	    public ResponseEntity<List<CandyPoint>> getAllUserCandyPointHistory() {
//	        List<CandyPoint> candyPoints = candyPointService.getAllUserCandyPointHistory();
//	        return new ResponseEntity<>(candyPoints, HttpStatus.OK);
//	    }
//
//	    // 특정 사용자의 특정 날짜에 해당하는 CandyPoint 기록 조회 API
//	    @GetMapping("/userCandyHistory/{userId}/{timeStamp}")
//	    public ResponseEntity<List<CandyPoint>> getUserCandyPointHistoryByTimeStamp(
//	            @PathVariable Long userId,
//	            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeStamp) {
//	        List<CandyPoint> candyPoints = candyPointService.getUserCandyPointHistoryByTimeStamp(userId, timeStamp);
//	        return new ResponseEntity<>(candyPoints, HttpStatus.OK);
//	    }
//
//	    // 특정 사용자의 총 CandyPoint 합계 조회 API
//	    @GetMapping("/TotalPoints/{userId}")
//	    public ResponseEntity<List<CandyPoint>> getTotalCandyPointsByUserId(@PathVariable Long userId) {
//	        List<CandyPoint> totalCandyPoints = candyPointService.getTotalCandyPointsByUserId(userId);
//	        return new ResponseEntity<>(totalCandyPoints, HttpStatus.OK);
//	    }
//}
