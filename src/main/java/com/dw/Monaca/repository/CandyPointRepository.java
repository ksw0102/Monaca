//package com.dw.Monaca.repository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.dw.Monaca.model.CandyPoint;
//
//public interface CandyPointRepository extends JpaRepository<CandyPoint, Long> {
//
//	List<CandyPoint> getUserCandyPointHistory(Long userId);
//
//	List<CandyPoint> findByUserIdAndTimeStamp(Long userId, LocalDateTime timeStamp);
//
//}
