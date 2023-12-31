package com.dw.Monaca.service;

import java.util.List;

import com.dw.Monaca.dto.QandADto;
import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.QandA;

// QandA 게시판
public interface QandAService {
	// 기능구현 예정

	// 게시글 삭제
	// 답변이 달리기 전까지만 게시글 수정가능(수정시 수정 된 게시글 알림(새로고침 필))
	// 갯수제한 없이 무한 답변 가능
	// 내가 아닌 다른사람이 쓴 게시글도 전체 조회 가능
	// 나의 방에서는 내가 쓴 게시글 만 조회 가능
	// 내가 쓴 게시글 중 원하는 게시글 만 선택해서 삭제 = 휴지통으로 보내기 (QandA 에서는 hidden ture)
	// 삭제됐던 게시글 중 선택 또는 전체 게시글 복구 가능 (hidden = false)
	// 답변 완료 시 답변 완료라고 표시 (새로고침 필)

	// 게시글 업로드
	public ResponseDto<Void> createQandA(QandADto qandaDto);

	public ResponseDto<List<QandA>> getAllQandA();

	public ResponseDto<QandA> deleteQandA(Long id);
	

}