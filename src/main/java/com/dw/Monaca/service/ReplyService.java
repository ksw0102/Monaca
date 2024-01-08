package com.dw.Monaca.service;

import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Reply;

// QandA 답변
public interface ReplyService {

	// 기능 구현 예정
	// 답변 등록
	// 답변 삭제
	// 답변 수정(등록 시에는 답변 등록이라고 뜨고, 수정 시에는 수정 답변 추가 등록(새로고침 필))

	public ResponseDto<Void> createReply(Reply reply);

	public ResponseDto<List<Reply>> getAllReply();

	public ResponseDto<Long> deleteReply(Long id);
}