package com.dw.Monaca.service;

import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.ExamPaper;

// 시험지
public interface ExamPaperService {
	// 기능 구현 예정
	// CRUD 모두 사용
	// 전체 ExamPaper 가져오기
	// 원하는 과목 시험지만 불러오기
	// 시험지 수정
	// 시험지 삭제
	// 시험지 업로드
	// 시험지 예약 기능 (hidden, false 사용)
	public ResponseDto<Void> createExamPaper(ExamPaper examPaper, Long loginId);

	public ResponseDto<List<ExamPaper>> getAllExamPaper();



//	public ResponseDto<Long> deleteExamPaper(Long id);
}