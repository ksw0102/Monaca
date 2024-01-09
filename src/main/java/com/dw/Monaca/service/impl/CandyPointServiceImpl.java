//package com.dw.Monaca.service.impl;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dw.Monaca.exception.InvalidRequestException;
//import com.dw.Monaca.model.Attendance;
//import com.dw.Monaca.model.Candy;
//import com.dw.Monaca.model.CandyPoint;
//import com.dw.Monaca.model.Examination;
//import com.dw.Monaca.model.ItemShop;
//import com.dw.Monaca.repository.AttendanceRepository;
//import com.dw.Monaca.repository.CandyPointRepository;
//import com.dw.Monaca.repository.CandyRepository;
//import com.dw.Monaca.repository.ExaminationRepository;
//import com.dw.Monaca.repository.ItemShopRepository;
//import com.dw.Monaca.service.CandyPointService;
//import jakarta.transaction.Transactional;
//
//@Service
//@Transactional
//public class CandyPointServiceImpl implements CandyPointService {
//
//	private final CandyPointRepository candyPointRepository;
//    private final AttendanceRepository attendanceRepository;
//    private final CandyRepository candyRepository;
//    private final ExaminationRepository examinationRepository;
//    private final ItemShopRepository itemShopRepository;
//
//	@Autowired
//	public CandyPointServiceImpl(CandyPointRepository candyPointRepository, AttendanceRepository attendanceRepository,
//			CandyRepository candyRepository, ExaminationRepository examinationRepository,
//			ItemShopRepository itemShopRepository) {
//		super();
//		this.candyPointRepository = candyPointRepository;
//		this.attendanceRepository = attendanceRepository;
//		this.candyRepository = candyRepository;
//		this.examinationRepository = examinationRepository;
//		this.itemShopRepository = itemShopRepository;
//	}
//	
//	@Override
//    public CandyPoint createCandyPoint(Long attendanceId, Long candyId, Long examinationId, Long itemShopId, int useHistory, String description) {
//		// 연관된 엔티티들을 찾아옴
//        Attendance attendance = attendanceRepository.findById(attendanceId)
//                .orElseThrow(() -> new InvalidRequestException("Attendance not found", "Invalid attendance ID"));
//        Candy candy = candyRepository.findById(candyId)
//                .orElseThrow(() -> new InvalidRequestException("Candy not found", "Invalid candy ID"));
//        Examination examination = examinationRepository.findById(examinationId)
//                .orElseThrow(() -> new InvalidRequestException("Examination not found", "Invalid examination ID"));
//        ItemShop itemShop = itemShopRepository.findById(itemShopId)
//                .orElseThrow(() -> new InvalidRequestException("ItemShop not found", "Invalid itemShop ID"));
//
//        // CandyPoint 생성
//        CandyPoint candyPoint = new CandyPoint();
//        candyPoint.setAttendance(attendance);
//        candyPoint.setCandy(candy);
//        candyPoint.setExamination(examination);
//        candyPoint.setItemShop(itemShop);
//        candyPoint.setUseHistory(useHistory);
//        candyPoint.setDescription(description);
//        candyPoint.setTimeStamp(LocalDateTime.now());
//
//     // CandyPoint 저장
//        return candyPointRepository.save(candyPoint);
//    }
//
//	// CandyPoint 삭제
//	@Override
//	public void deleteCandyPoint(Long candyPointId) {
//	    Optional<CandyPoint> candyPointOptional = candyPointRepository.findById(candyPointId);
//
//	    if (candyPointOptional.isEmpty()) {
//	        throw new InvalidRequestException(Long.toString(candyPointId), "차감할 candyPoint가 없습니다.");
//	    }
//
//	    candyPointRepository.deleteById(candyPointId);
//	}
//	
//	// 특정 사용자의 CandyPoint 기록 조회
//	@Override
//	public List<CandyPoint> getUserCandyPointHistory(Long userId) {
//	    List<CandyPoint> candyPoints = candyPointRepository.getUserCandyPointHistory(userId);
//	    return candyPoints;
//	}
//
//	// 모든 사용자의 CandyPoint 기록 조회
//	@Override
//	public List<CandyPoint> getAllUserCandyPointHistory() {
//	    List<CandyPoint> candyPoints = candyPointRepository.findAll();
//
//	    if (candyPoints.isEmpty()) {
//	        throw new InvalidRequestException("CandyPoints empty", "CandyPoint가 존재하지 않습니다.");
//	    }
//
//	    return candyPoints;
//	}
//
//	// 특정 사용자의 특정 날짜에 해당하는 CandyPoint 기록 조회
//	@Override
//	public List<CandyPoint> getUserCandyPointHistoryByTimeStamp(Long userId, LocalDateTime timeStamp) {
//	    List<CandyPoint> candyPoints = candyPointRepository.findByUserIdAndTimeStamp(userId, timeStamp);
//	    return candyPoints;
//	}
//
//	// 특정 사용자의 총 CandyPoint 합계 조회
//	@Override
//	public List<CandyPoint> getTotalCandyPointsByUserId(Long userId) {
//		  // 해당 userId를 가진 사용자의 모든 candyPoint 기록 가져오기
//	    List<CandyPoint> userCandyPoints = candyPointRepository.getUserCandyPointHistory(userId);
//
//	    // 총합을 저장할 변수 초기화
//	    int totalCandyPoints = 0;
//
//	    // 각 candyPoint의 useHistory 값에 따라 총합을 계산
//	    for (CandyPoint candyPoint : userCandyPoints) {
//	        // 사용 내역이 증가면 추가, 차감이면 차감
//	        if (candyPoint.getUseHistory() == 1) {
//	            totalCandyPoints += candyPoint.getUseHistory();
//	        } else {
//	            totalCandyPoints -= candyPoint.getUseHistory();
//	        }
//	    }
//
//	    // 계산된 총합을 CandyPoint 객체로 감싸서 반환
//	    CandyPoint totalCandyPoint = new CandyPoint();
//	    totalCandyPoint.setUseHistory(totalCandyPoints);
//	    return List.of(totalCandyPoint);
//	}
//
//}
