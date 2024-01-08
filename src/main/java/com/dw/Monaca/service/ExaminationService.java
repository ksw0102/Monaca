package com.dw.Monaca.service;

import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Examination;

public interface ExaminationService {
	// 기능 구현
	// 전체 Examination 불러오기
	// 검색 기능으로 원하는 강의 성적만 불러올 수 있게 함

public ResponseDto<Void> createExamination(Examination examination, String loginId);

public ResponseDto<List<Examination>> getAllExamination();

}