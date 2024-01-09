package com.dw.Monaca.service;

import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.QandABin;

// QandA 휴지통
public interface QandABinService {
	// 기능 구현 예정
	// 원하는 게시글 만 선택해서 담긴 게시글을 복구하거나 완전 삭제 가능
	// 완전 삭제 하지 않고 남겨진 게시글은 일정시간(30)뒤에 자동 삭제
	// 원하는 게시글 복구
	// 전체 게시글 복구 가능
	// 원하는 게시글 삭제
	// 휴지통에 있는 전체 게시글 삭제 가능

	public ResponseDto<List<QandABin>> getAllQandABin();

//	public ResponseDto<Long> deleteQandABin(Long id);

}