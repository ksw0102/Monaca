//package com.dw.Monaca.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import com.dw.Monaca.model.CandyPoint;
//
//public interface CandyPointService {
//
//	CandyPoint createCandyPoint(Long attendanceId, Long candyId, Long examinationId, Long itemShopId, int useHistory,
//			String description);
//
//	void deleteCandyPoint(Long candyPointId);
//
//	List<CandyPoint> getUserCandyPointHistory(Long userId);
//
//	List<CandyPoint> getAllUserCandyPointHistory();
//
//	List<CandyPoint> getUserCandyPointHistoryByTimeStamp(Long userId, LocalDateTime timeStamp);
//
//	List<CandyPoint> getTotalCandyPointsByUserId(Long userId);
//
//}
