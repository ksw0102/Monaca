package com.dw.Monaca.service;

// 강의실, 현재 수강중인 강의만 보여지는 것
public interface ClassRoomService {

	// 기능 구현
	// get 메소드
	// 이미 완료한 강의는 숨김 처리
	// 타임스탬프 사용 (수강 완료 한 강의는 진도율 100%가 되어 내역에 저장 됨. 
	// 진도율 100%는 변하지 않고 강의 시청시간만 0초로 초기화.)
}
