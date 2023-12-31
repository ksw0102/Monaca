package com.dw.Monaca.service;
// 강의

import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Lecture;

public interface LectureService {
 // 모든 Lecture 불러오기
	// Lecture 카테고리 별 불러오기
	// 교수 별 불러오기
	// CRUD 모두 사용
	// 강의 업로드
	// 강의 삭제
	// 강의 수정
	public ResponseDto<List<Lecture>> getAllLecture();
}
